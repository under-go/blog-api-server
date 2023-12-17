package link.wafflebox.api.user.dto;


import lombok.Getter;

@Getter
public class User {
    private final Long no;
    private final String id;
    private final String nickname;

    public User(Long no, String id, String nickname) {
        this.no = no;
        this.id = id;
        this.nickname = nickname;
    }
}
