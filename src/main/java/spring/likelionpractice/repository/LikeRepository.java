package spring.likelionpractice.repository;

import spring.likelionpractice.domain.Article;
import spring.likelionpractice.domain.Member;

import java.util.List;

public interface LikeRepository {
    public void clickLike(Member member, Article article);       // 유저당 게시글에 좋아요 1개 (한번 더 누르면 좋아요 취소)

    public Article findByArticleId(Long articleId);         // 게시글 하나 불러올 때 해다 게시글의 좋아요 개수 불러오기

    public List<Article> findByArticleLikeMe(Long memberId);  // 내가 좋아요한 게시물 목록 조회

    public List<Article> findByArticleLikeCount(Long articleId);        // 게시글 리스트 불러올 때 각 게시글별 좋아요 개수 불러오기

    public List<Article> findBySortLike();          // 게시글 좋아요 개수 내림차순 정렬 조회(좋아요 많은 거 부터)
}
