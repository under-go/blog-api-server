package link.wafflebox.api.article;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ArticleController {
    private final ArticleService articleService = new ArticleService();

    @GetMapping("articles")
    @ResponseBody
    public List<Article> getArticles(Model model) {
        List<Article> result = articleService.getArticles();
        return result;
    }
}
