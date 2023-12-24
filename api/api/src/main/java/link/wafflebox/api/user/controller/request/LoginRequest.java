package link.wafflebox.api.user.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginRequest {
    private final String id;
    private final String password;
}
