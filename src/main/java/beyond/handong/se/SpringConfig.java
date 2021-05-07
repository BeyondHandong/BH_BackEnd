package beyond.handong.se;


import beyond.handong.se.repository.JpaPostRepository;
import beyond.handong.se.repository.PostRepository;
import beyond.handong.se.service.PostService;
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

}
