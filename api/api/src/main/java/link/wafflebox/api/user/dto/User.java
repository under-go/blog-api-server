package link.wafflebox.api.user.dto;


public class User {
    private Long no;
    private String id;
    private String nickname;

    public User(Long no, String id, String nickname) {
        this.no = no;
        this.id = id;
        this.nickname = nickname;
    }

    public Long getNo() {
        return no;
    }

    public String getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
