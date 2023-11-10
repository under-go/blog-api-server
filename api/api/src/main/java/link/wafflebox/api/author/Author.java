package link.wafflebox.api.author;

import java.text.DateFormat;

public class Author {
    private final Long id;
    private final String nickname;

    public Author(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
