package link.wafflebox.api.user.service;

import link.wafflebox.api.global.util.JwtUtil;
import link.wafflebox.api.user.dto.AuthToken;
import link.wafflebox.api.user.dto.UserDto;
import link.wafflebox.api.user.repository.JpaUserRepository;
import link.wafflebox.api.user.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JpaUserRepository userRepository;
    private final JwtUtil jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public List<UserDto> findAllUsers() {
        List<UserDto> users = new ArrayList<>();
        userRepository.findAll().forEach(e -> users.add(UserDto.fromEntity(e)));
        return users;
    }

    public Long signUp(String id, String password, String nickname) {
        System.out.println(id + password + encrypt(password) + nickname);
        UserEntity savedEntity = userRepository.saveAndFlush(new UserEntity(id, encrypt(password), nickname));
        return savedEntity.getNo();
    }

    public Optional<AuthToken> signIn(String id, String password) {
        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(id, password));

            Map<String, Object> payloads = new HashMap<>();
            payloads.put("id", id);
            String accessToken = jwtService.generateToken(payloads);

            return Optional.of(new AuthToken(accessToken, accessToken));
        } catch(BadCredentialsException e) {
            return Optional.empty();
        } catch(Exception e) {
            return Optional.empty();
        }
    }

    private String encrypt(String string) {
        return passwordEncoder.encode(string);
    }
}
