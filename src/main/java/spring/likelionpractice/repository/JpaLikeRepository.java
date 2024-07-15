package spring.likelionpractice.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.likelionpractice.domain.Article;
import spring.likelionpractice.domain.Member;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaLikeRepository implements LikeRepository {
    private final EntityManager em;
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;

    @Override
    public void clickLike(Member member, Article article) {

    }

    @Override
    public Article findByArticleId(Long articleId) {
        Article article = articleRepository.findById(articleId);
    }

    @Override
    public List<Article> findByArticleLikeMe(Long memberId) {
        return List.of();
    }

    @Override
    public List<Article> findByArticleLikeCount(Long articleId) {
        return List.of();
    }

    @Override
    public List<Article> findBySortLike() {
        return List.of();
    }
}
