package link.wafflebox.api.global.util;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public interface JwtUtil {
    String generateToken(Map<String, Object> payloads);
    Map<String, Object> parseClaims(String token);
    Map<String, Object> resolveClaims(HttpServletRequest request);
    String resolveToken(HttpServletRequest request);
    boolean validateClaims(Map<String, Object> claims);
    String getSubject(Map<String, Object> claims);
}
