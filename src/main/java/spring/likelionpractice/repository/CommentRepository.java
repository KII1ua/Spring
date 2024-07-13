package spring.likelionpractice.repository;

import spring.likelionpractice.domain.Article;
import spring.likelionpractice.domain.Comment;
import spring.likelionpractice.domain.Member;

import java.util.List;

public interface CommentRepository {
    Comment findById(Long id);

    void saveComment(Comment comment);

    void deleteComment(Comment comment);

    List<Comment> findArticleComment(Article article);

    List<Comment> findMemberComment(Member member);

    List<Article> findMemberCommentArticle(Member member);

}
