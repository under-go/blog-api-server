package link.wafflebox.api.global.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClaims;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtilImpl implements JwtUtil {

    private final long accessTokenValidity = 1000L*60*60*24;

    private final String TOKEN_HEADER = "Authorization";
    private final String TOKEN_PREFIX = "Bearer ";
    @Value("${external.key.hmac-secret}")
    private String secretKey;
    private JwtParser jwtParser;

    @PostConstruct
    public void init() {
        this.jwtParser = Jwts.parser().setSigningKey(secretKey);
    }


    public String generateToken(Map<String, Object> payloads) {
        Map<String, Object> headers = new HashMap<>();

        headers.put("alg", "HS256");
        headers.put("typ", "JWT");

        return Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+accessTokenValidity))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Map<String, Object> parseClaims(String token) {
        return jwtParser.parseClaimsJws(token).getBody();
    }

    public Map<String, Object> resolveClaims(HttpServletRequest request) {
        try {
            String token = resolveToken(request);

            if (token == null) {
                return null;
            }

            return parseClaims(token);
        } catch (ExpiredJwtException e) {
            request.setAttribute("expired", e.getMessage());
            throw e;
        } catch (Exception e) {
            request.setAttribute("invalid", e.getMessage());
            throw e;
        }
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(TOKEN_HEADER);

        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }

        return null;
    }

    public boolean validateClaims(Map<String, Object> claims) throws AuthenticationException {
        DefaultClaims defaultClaims = new DefaultClaims(claims);
        return defaultClaims.getExpiration().after(new Date());
    }
}
