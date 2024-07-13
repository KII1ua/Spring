package spring.likelionpractice.repository;

import jakarta.persistence.EntityManager;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.likelionpractice.domain.Article;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaArticleRepository implements ArticleRepository {

    private final EntityManager em;

    @Override
    public Article saveNewArticle(Article article) {
        em.persist(article);
        return article;
    }

    @Override
    public void deleteArticle(Article article) {
        em.remove(article);
    }

    @Override
    public Article findById(Long articleId) {
        return em.find(Article.class, articleId);
    }

    @Override
    public List<Article> findAll() {
        return em.createQuery("Select a from Article a", Article.class).getResultList();
    }

    @Override
    public List<Article> findUserAll(Long memberId) {
        return em.createQuery("Select a from Article a where a.writer = :m", Article.class)
                .setParameter("m", memberId).getResultList();
    }
}
