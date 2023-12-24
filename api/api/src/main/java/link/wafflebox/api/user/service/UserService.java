package link.wafflebox.api.user.service;

import link.wafflebox.api.global.dto.Error;
import link.wafflebox.api.global.dto.ErrorCode;
import link.wafflebox.api.global.dto.Result;
import link.wafflebox.api.global.util.JwtUtil;
import link.wafflebox.api.user.dto.AuthToken;
import link.wafflebox.api.user.dto.UserDto;
import link.wafflebox.api.user.repository.JpaUserRepository;
import link.wafflebox.api.user.repository.entity.Role;
import link.wafflebox.api.user.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.NonUniqueObjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public Result<List<UserDto>> findAllUsers() {
        List<UserDto> users = new ArrayList<>();
        userRepository.findAll().forEach(e -> users.add(UserDto.fromEntity(e)));
        return Result.success(users);
    }

    public Result<Long> signUp(String id, String password, String nickname) {
        try {
            UserEntity savedEntity = userRepository.saveAndFlush(new UserEntity(id, encrypt(password), nickname, Role.USER));
            return Result.success(savedEntity.getNo());
        } catch(DataIntegrityViolationException e) {
            log.debug(e.getMessage(), e);
            return Result.fail(new Error(HttpStatus.BAD_REQUEST, "이미 사용 중인 아이디 또는 닉네임입니다.", ErrorCode.DUPLICATED_ID_NICKNAME));
        } catch(Exception e) {
            log.error(e.getMessage(), e);
            return Result.fail(new Error(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 오류가 발생했습니다."));
        }

    }

    public Result<AuthToken> signIn(String id, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(id, password));

            Map<String, Object> payloads = new HashMap<>();
            payloads.put("id", id);
            String accessToken = jwtService.generateToken(payloads);

            return Result.success(new AuthToken(accessToken));
        } catch(BadCredentialsException e) {
            log.debug(e.getMessage());
            return Result.fail(new Error(HttpStatus.UNAUTHORIZED, "아이디 또는 비밀번호가 틀립니다."));
        } catch(Exception e) {
            log.error(e.getMessage());
            return Result.fail(new Error(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 오류가 발생했습니다."));
        }
    }

    private String encrypt(String string) {
        return passwordEncoder.encode(string);
    }
}
