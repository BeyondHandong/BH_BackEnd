package beyond.handong.se.service;

import beyond.handong.se.model.Helpful;
import beyond.handong.se.model.Post;
import beyond.handong.se.model.Scrap;
import beyond.handong.se.repository.CommentRepository;
import beyond.handong.se.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class PostService{

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
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

    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    public List<Post> findBySector(String sector, List<String> countries, List<String> categories, String keyword){
        return postRepository.findBySector(sector, countries, categories, keyword);
    }

    public Optional<Post> findOne(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        post.get().setViewNum(post.get().getViewNum() + 1);
        return post;
    }

    public List<Post> findMyPosts(Long writerId) { return postRepository.findByWriterId(writerId); }

    public void delete(Long post_id){
        commentRepository.deleteByPostId(post_id);
        postRepository.delete(post_id);
    }

    public void updateHelpful(Helpful helpful){
        Optional<Helpful> hf = postRepository.findHelpfuById(helpful);
        if(!hf.isPresent()){
            postRepository.newHelpful(helpful);
            editHelpfulNum(helpful.getPostId(), 1L);
        }
        else{
            helpful.setId(hf.get().getId());
            postRepository.deleteHelpful(helpful);
            editHelpfulNum(helpful.getPostId(), -1L);
        }
    }

    public boolean isHelpful(Long postId, Long userId){
        Helpful helpful = new Helpful();
        helpful.setUserId(userId);
        helpful.setPostId(postId);
        Optional<Helpful> hf = postRepository.findHelpfuById(helpful);
        return hf.isPresent();
    }

    public Long editHelpfulNum(Long postId, Long num){
        System.out.println("pid:"+postId);
        Optional<Post> post = postRepository.findById(postId).stream().findAny();
        if(post.isPresent()) {
            post.get().setHelpfulNum(post.get().getHelpfulNum() + num);
            return post.get().getHelpfulNum();
        }
        else return -1L;
    }

    public Long editScrapNum(Long postId, Long num){
        Optional<Post> post = postRepository.findById(postId).stream().findAny();
        if(post.isPresent()) {
            post.get().setScrapNum(post.get().getScrapNum() + num);
            return post.get().getScrapNum();
        }
        else return -1L;
    }


}
