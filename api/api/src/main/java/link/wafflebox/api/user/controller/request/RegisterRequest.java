package link.wafflebox.api.user.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterRequest {
    private final String id;
    private final String password;
    private final String nickname;
}
