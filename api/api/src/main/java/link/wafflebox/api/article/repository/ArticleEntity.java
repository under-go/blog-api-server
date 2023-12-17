package link.wafflebox.api.article.repository;

import lombok.*;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="article")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String summary;
    private String content;
    @Column(name="author_id")
    private Long authorId;
    @Column(name="created_at")
    private OffsetDateTime createdAt;

    @Builder

    public ArticleEntity(String title, String summary, String content, Long authorId, OffsetDateTime createdAt) {
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.authorId = authorId;
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
