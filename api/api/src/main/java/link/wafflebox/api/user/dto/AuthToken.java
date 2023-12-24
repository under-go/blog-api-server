package link.wafflebox.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthToken {
    private final String accessToken;
//    private final String refreshToken;
}
