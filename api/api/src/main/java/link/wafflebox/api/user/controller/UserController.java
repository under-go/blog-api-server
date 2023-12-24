package link.wafflebox.api.user.controller;

import link.wafflebox.api.global.dto.ApiResponse;
import link.wafflebox.api.global.dto.Error;
import link.wafflebox.api.global.dto.Result;
import link.wafflebox.api.global.util.JwtUtil;
import link.wafflebox.api.user.controller.request.LoginRequest;
import link.wafflebox.api.user.controller.request.RegisterRequest;
import link.wafflebox.api.user.controller.response.RegisterResponse;
import link.wafflebox.api.user.dto.AuthToken;
import link.wafflebox.api.user.dto.UserDto;
import link.wafflebox.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<ApiResponse> getUsers() {
        Result<List<UserDto>> result = userService.findAllUsers();

        if (result.isSuccessful()) {
            return ResponseEntity
                    .ok()
                    .body(ApiResponse.ok(result.getData()));
        }

        return ResponseEntity
                .status(result.getError().getHttpStatusCode())
                .body(ApiResponse.fromError(result.getError()));
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest request) {
        Result<Long> result = userService.signUp(request.getId(), request.getPassword(), request.getNickname());

        if (result.isSuccessful()) {
            return ResponseEntity
                    .ok()
                    .body(ApiResponse.ok(new RegisterResponse(result.getData())));
        }

        return ResponseEntity
                .status(result.getError().getHttpStatusCode())
                .body(ApiResponse.fromError(result.getError()));
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
        Result<AuthToken> result = userService.signIn(request.getId(), request.getPassword());

        if (result.isSuccessful()) {
            return ResponseEntity
                    .ok()
                    .body(ApiResponse.ok(result.getData()));
        }

        return ResponseEntity
                .status(result.getError().getHttpStatusCode())
                .body(ApiResponse.fromError(result.getError()));
    }
}
