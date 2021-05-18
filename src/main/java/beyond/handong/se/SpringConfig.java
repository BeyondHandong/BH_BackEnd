package beyond.handong.se;


import beyond.handong.se.repository.JpaPostRepository;
import beyond.handong.se.repository.JpaUserRepository;
import beyond.handong.se.repository.PostRepository;
import beyond.handong.se.repository.UserRepository;
import beyond.handong.se.service.PostService;
import beyond.handong.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
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
    public UserRepository userRepository(){
        return new JpaUserRepository(em);
    }
    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }
}
