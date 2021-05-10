package beyond.handong.se.service;

import beyond.handong.se.model.Post;
import beyond.handong.se.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class PostServiceIntegrationTest {

    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepository;

    // 테스트 코드는 과감하게 한글로 적어도 된다.
    // 테스트 코드는 빌드될 때 포함되지 않는다.
    @Test
    void 새글작성() {
        // given
        Post post = new Post();
        post.setTitle("test");
        post.setWriterId(2L);

        post.setHelpfulNum(0l);
        post.setScrapNum(0l);
        post.setViewNum(0l);

        Date writeDate = new Date();
        post.setWriteDate(writeDate);
        post.setWriteDate(writeDate);

        // when
        Long saveId = postService.join(post);

        // then
        Post findPost = postService.findOne(saveId).get();
        assertThat(post.getTitle()).isEqualTo(findPost.getTitle());
    }

    @Test
    void findPosts() {
    }

    @Test
    void findOne() {
    }
}
