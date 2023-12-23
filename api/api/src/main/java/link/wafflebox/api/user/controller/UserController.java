package link.wafflebox.api.user.controller;

import link.wafflebox.api.global.dto.ApiResponse;
import link.wafflebox.api.global.util.JwtUtil;
import link.wafflebox.api.user.controller.request.LoginRequest;
import link.wafflebox.api.user.dto.AuthToken;
import link.wafflebox.api.user.dto.UserDto;
import link.wafflebox.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
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
    public List<UserDto> getUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/signup")
    @ResponseBody
    public Map<String, Long> signUp(@RequestBody Map<String, String> params) {
        Long userNo = userService.signUp(params.get("id"), params.get("password"), params.get("nickname"));
        Map<String, Long> result = new HashMap<>();
        result.put("no", userNo);
        return result;
    }

    @PostMapping("/login")
    @ResponseBody
    public AuthToken login(@RequestBody LoginRequest request) {
        Optional<AuthToken> result = userService.signIn(request.getId(), request.getPassword());
        return result.orElse(null);
    }
}
