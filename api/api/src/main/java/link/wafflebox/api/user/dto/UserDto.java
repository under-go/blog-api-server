package link.wafflebox.api.user.dto;


import link.wafflebox.api.user.repository.entity.Role;
import link.wafflebox.api.user.repository.entity.UserEntity;
import lombok.Getter;

@Getter
public class UserDto {
    private final Long no;
    private final String id;
    private final String nickname;
    private final Role role;

    public UserDto(Long no, String id, String nickname, Role role) {
        this.no = no;
        this.id = id;
        this.nickname = nickname;
        this.role = role;
    }

    public static UserDto fromEntity(UserEntity entity) {
        return new UserDto(entity.getNo(), entity.getUserId(), entity.getNickname(), entity.getRole());
    }
}
