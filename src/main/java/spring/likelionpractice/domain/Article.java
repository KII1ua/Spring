package spring.likelionpractice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Article {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member writer;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Article(String title, String content, Member member) {
        this.writer = writer;
        this.createDate = LocalDateTime.now();
        this.updateDate = this.createDate;
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
        this.updateDate = LocalDateTime.now();
    }

}
