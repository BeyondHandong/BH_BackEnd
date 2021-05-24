package beyond.handong.se;


import beyond.handong.se.repository.*;
import beyond.handong.se.service.CommentService;
import beyond.handong.se.service.PostService;
import beyond.handong.se.service.ScrapService;
import beyond.handong.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;
    private final CommentRepository commentRepository;

    public SpringConfig(EntityManager em, CommentRepository commentRepository) {
        this.em = em;
        this.commentRepository = commentRepository;
    }

    @Bean
    public PostService postService() {
        return new PostService(postRepository());
    }

    @Bean
    public PostRepository postRepository() {
        return new JpaPostRepository(em);
    }

    @Bean
    public CommentService commentService() {
        return new CommentService(commentRepository);
    }

    @Bean
    public UserRepository userRepository(){
        return new JpaUserRepository(em);
    }
    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }

    @Bean
    public ScrapRepository scrapRepository(){
        return new JpaScrapRepository(em);
    }
    @Bean
    public ScrapService scrapService() {
        return new ScrapService(scrapRepository());
    }
}
