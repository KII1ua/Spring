package spring.likelionpractice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.likelionpractice.DTO.LikeDTO.*;
import spring.likelionpractice.domain.Member;
import spring.likelionpractice.service.LikeService;
import spring.likelionpractice.service.MemberService;

@RestController
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;
    private final MemberService memberService;

    @PostMapping("/like")
    public ResponseEntity<LikeResponse> like(@RequestBody LikeRequest request) {
        Member member = memberService.tokentoMember(request.getToken());
        boolean liked = likeService.clickLike(request.getArticleId(), member.getId());
        Long likeCount = likeService.findByArticleIdLikeCount(request.getArticleId());

        LikeResponse response = new LikeResponse(liked, likeCount);
        return ResponseEntity.ok(response);
    }
}
