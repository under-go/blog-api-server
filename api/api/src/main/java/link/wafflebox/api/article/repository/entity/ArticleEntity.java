package link.wafflebox.api.article.repository.entity;

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
    @Column(name="author_no")
    private Long authorNo;
    @Column(name="created_at")
    private OffsetDateTime createdAt;

    @Builder
    public ArticleEntity(String title, String summary, String content, Long authorNo, OffsetDateTime createdAt) {
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.authorNo = authorNo;
        this.createdAt = createdAt;
    }
}
