package link.wafflebox.api.article.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import link.wafflebox.api.user.dto.UserDto;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
public class Article {
    private final Long id;
    private final String title;
    private final String summary;
    private final String content;
    @JsonProperty("author")
    private final UserDto userDto;
    @JsonProperty("createdAt")
    private final OffsetDateTime createdAt;

    public Article(Long id, String title, String summary, String content, UserDto userDto, OffsetDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.userDto = userDto;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", author=" + userDto +
                ", createdAt=" + createdAt +
                '}';
    }
}
