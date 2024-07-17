package spring.likelionpractice.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.likelionpractice.domain.Article;
import spring.likelionpractice.domain.Like;
import spring.likelionpractice.domain.Member;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaLikeRepository implements LikeRepository {

    private final EntityManager em;
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;

    @Override
    public void clickLike(Like like) {
        em.persist(like);
    }

    @Override
    public void deleteLike(Like like) {
        em.remove(like);
    }

    @Override
    public Like findByMemberAndArticle(Member member, Article article) {
        return em.createQuery("SELECT l FROM Like l WHERE l.member = :member AND l.article = :article", Like.class)
                .setParameter("member", member)
                .setParameter("article", article)
                .getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public Long findByArticleIdLikeCount(Long articleId) {
        Article article = articleRepository.findById(articleId);
        return article.getLikeCount();      // 게시물 좋아요 개수 불러오기
    }

    @Override
    public List<Article> findByArticleLikeMe(Member member) {
        return em.createQuery("Select Distinct l.article from Like l where l.member.id = :member", Article.class)
                .setParameter("member", member).getResultList();
    }

    @Override
    public List<Article> findByArticleLikeCount(Article article) {
        return em.createQuery("Select a from Article a Left Join Like l on a.id = l.article.id " +
                "group by a.id Order by Count(l) Desc", Article.class).getResultList();
    }

    @Override
    public List<Article> findBySortLike() {
        return em.createQuery("Select a from Article a  Order by a.likeCount Desc", Article.class)
                .getResultList();
    }

}
