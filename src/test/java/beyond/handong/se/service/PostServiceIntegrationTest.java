package beyond.handong.se.service;

import beyond.handong.se.model.Post;
import beyond.handong.se.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
    void 회원가입() {
        // given
        Post post = new Post();
        post.setTitle("test");
        post.setWriterId(2L);

        // when
        Long saveId = postService.join(post);

        // then
        Post findPost = postService.findOne(saveId).get();
        assertThat(post.getTitle()).isEqualTo(findPost.getTitle());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Post post1 = new Post();
        post1.setTitle("test");
        post1.setWriterId(2L);

        Post post2 = new Post();
        post2.setTitle("test");
        post2.setWriterId(2L);

        // when
        postService.join(post1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> postService.join(post2));

//        try {
//            PostService.join(Post2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        // then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findPosts() {
    }

    @Test
    void findOne() {
    }
}
