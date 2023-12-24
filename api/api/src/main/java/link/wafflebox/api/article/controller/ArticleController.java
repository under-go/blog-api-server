package link.wafflebox.api.article.controller;

import link.wafflebox.api.article.service.ArticleService;
import link.wafflebox.api.article.dto.Article;
import link.wafflebox.api.global.dto.ApiResponse;
import link.wafflebox.api.global.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/article/all")
    @ResponseBody
    public ResponseEntity<ApiResponse> getArticles(Model model) {
        Result<List<Article>> result = articleService.getArticles();

        if (result.isSuccessful()) {
            return ResponseEntity
                    .ok()
                    .body(ApiResponse.ok(result.getData()));
        }

        return ResponseEntity
                .status(result.getError().getHttpStatusCode())
                .body(ApiResponse.fromError(result.getError()));
    }
}
