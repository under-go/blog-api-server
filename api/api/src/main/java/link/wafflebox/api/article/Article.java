package link.wafflebox.api.article;

import com.fasterxml.jackson.annotation.JsonProperty;
import link.wafflebox.api.author.Author;

import java.time.OffsetDateTime;

public class Article {
    private final Long id;
    private final String title;
    private final String summary;
    private final String content;
    private final Author author;
    @JsonProperty("createdAt")
    private final OffsetDateTime createdAt;

    public Article(Long id, String title, String summary, String content, Author author, OffsetDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getContent() {
        return content;
    }

    public Author getAuthor() {
        return author;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", createdAt=" + createdAt +
                '}';
    }
}
