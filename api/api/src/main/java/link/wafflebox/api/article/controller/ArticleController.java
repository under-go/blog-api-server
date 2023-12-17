package link.wafflebox.api.article.controller;

import link.wafflebox.api.article.service.ArticleService;
import link.wafflebox.api.article.dto.Article;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("articles")
    @ResponseBody
    public List<Article> getArticles(Model model) {
        List<Article> result = articleService.getArticles();
        return result;
    }
}
