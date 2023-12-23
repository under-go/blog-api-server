package link.wafflebox.api.user.dto;


import link.wafflebox.api.user.repository.entity.UserEntity;
import lombok.Getter;

@Getter
public class UserDto {
    private final Long no;
    private final String id;
    private final String nickname;

    public UserDto(Long no, String id, String nickname) {
        this.no = no;
        this.id = id;
        this.nickname = nickname;
    }

    public static UserDto fromEntity(UserEntity entity) {
        return new UserDto(entity.getNo(), entity.getUserId(), entity.getNickname());
    }
}
