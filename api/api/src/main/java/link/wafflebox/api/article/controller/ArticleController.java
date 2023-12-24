package link.wafflebox.api.article.controller;

import link.wafflebox.api.article.controller.request.PostNewArticleRequest;
import link.wafflebox.api.article.service.ArticleService;
import link.wafflebox.api.article.dto.Article;
import link.wafflebox.api.global.dto.ApiResponse;
import link.wafflebox.api.global.dto.Error;
import link.wafflebox.api.global.dto.Result;
import link.wafflebox.api.user.dto.UserDto;
import link.wafflebox.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final UserService userService;

    @GetMapping("/article/all")
    @ResponseBody
    public ResponseEntity<ApiResponse> getAllArticle(Model model) {
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

    @PostMapping("/article/new")
    @ResponseBody
    public ResponseEntity<ApiResponse> postNewArticle(@RequestBody PostNewArticleRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Result<UserDto> userDtoResult = userService.findUser(authentication.getName());

        if (userDtoResult.isFail()) {
            return ResponseEntity
                    .status(userDtoResult.getError().getHttpStatusCode())
                    .body(ApiResponse.fromError(userDtoResult.getError()));
        }

        UserDto author = userDtoResult.getData();
        Result<Long> result = articleService.createArticle(request.getTitle(), request.getSummary(), request.getContent(), author.getNo());

        if (result.isFail()) {
            return ResponseEntity
                    .status(result.getError().getHttpStatusCode())
                    .body(ApiResponse.fromError(result.getError()));
        }

        return ResponseEntity
                .ok()
                .body(ApiResponse.ok(result.getData()));
    }
}
