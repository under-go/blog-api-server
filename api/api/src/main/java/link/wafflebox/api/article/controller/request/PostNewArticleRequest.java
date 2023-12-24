package link.wafflebox.api.article.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostNewArticleRequest {
    private final String title;
    private final String summary;
    private final String content;
}
