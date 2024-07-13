package spring.likelionpractice.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.likelionpractice.domain.Article;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ArticleDTO {

    @Data
    public static class ResponseArticle {
        private String title;
        private String content;
        private String writer;
        private LocalDateTime createDate;
        private boolean ischange;

        public ResponseArticle(Article article) {
            this.title = article.getTitle();
            this.content = article.getContent();
            this.writer = article.getWriter().getNickname();
            this.createDate = article.getCreateDate();

            if(article.getCreateDate().equals(article.getCreateDate())) {
                this.ischange = false;
            } else {
                this.ischange = true;
            }
        }
    }

    @Data
    public static class requestArticle {
        private String title;
        private String content;
        private String token;
    }

    @Data
    public static class deleteArticle {
        private String token;
    }

}
