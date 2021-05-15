package beyond.handong.se.service;

import beyond.handong.se.model.Post;
import beyond.handong.se.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class PostService{

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Post post) {
        postRepository.save(post);
        return post.getId();
    }

    public void update(Post post) {
        postRepository.edit(post);
    }

    private void validateDuplicatedMember(Post post) {
        postRepository.findByTitle(post.getTitle())
                .ifPresent(post1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    public List<Post> findBySector(String sector, List<String> countries, List<String> categories){
        return postRepository.findBySector(sector, countries, categories);
    }

    public Optional<Post> findOne(Long postId) {
        return postRepository.findById(postId);
    }
}
