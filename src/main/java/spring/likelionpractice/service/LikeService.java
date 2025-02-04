package spring.likelionpractice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.likelionpractice.domain.Article;
import spring.likelionpractice.domain.Like;
import spring.likelionpractice.domain.Member;
import spring.likelionpractice.repository.ArticleRepository;
import spring.likelionpractice.repository.LikeRepository;
import spring.likelionpractice.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeService {
    private final LikeRepository likeRepository;
    private final MemberService memberService;
    private final ArticleService articleService;

    @Transactional
    public boolean clickLike(Long articleId, Long memberId) {     // 게시물에 좋아요가 없으면 추가, 있으면 없애고 -1
        Article article = articleService.findArticle(articleId);
        Member member = memberService.findById(memberId);

        Like isLike = likeRepository.findByMemberAndArticle(member, article);

        if(isLike == null) {
            Like like = new Like(member, article);
            likeRepository.clickLike(like);
            article.setLikeCount(article.getLikeCount() + 1);
            return true;
        } else {
            likeRepository.deleteLike(isLike);
            article.setLikeCount(article.getLikeCount() - 1);
            return false;
        }
    }

    @Transactional
    public List<Article> findByArticleLikeMe(Member member) {
        return likeRepository.findByArticleLikeMe(member);
    }

    @Transactional
    public Long findByArticleIdLikeCount(Long articleId) {
        Article article = articleService.findArticle(articleId);
        return article.getLikeCount();
    }

}
