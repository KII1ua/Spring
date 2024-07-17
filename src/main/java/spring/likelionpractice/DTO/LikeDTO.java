package spring.likelionpractice.DTO;

import lombok.Data;

public class LikeDTO {
    @Data
    public static class LikeRequest {
        private Long articleId;
        private String token;
    }

    @Data
    public static class LikeResponse {
        private boolean liked;
        private Long likeCount;

        public LikeResponse(boolean liked, Long likeCount) {
            this.liked = liked;
            this.likeCount = likeCount;
        }
    }
}
