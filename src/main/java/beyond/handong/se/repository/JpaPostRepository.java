package beyond.handong.se.repository;

import beyond.handong.se.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaPostRepository implements PostRepository{

    private EntityManager em;

    public JpaPostRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Post save(Post post) {
        em.persist(post);
        return post;
    }

    @Override
    public Optional<Post> findById(Long id) {
        Post post = em.find(Post.class, id);
        return Optional.ofNullable(post);
    }

    @Override
    public Optional<Post> findByTitle(String title) {
        List<Post> result = em.createQuery("select m from Post m where m.title = :title", Post.class)
                .setParameter("title", title)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Post> findAll() {
        return em.createQuery("select m from Post m", Post.class)
                .getResultList();
    }

    @Override
    public List<Post> findAll(List<String> types, List<String> countries, List<String> categories) {

        List<Post> results = em.createQuery("select m from Post m where m.type in :types and m.country in :countries and m.category in :categories", Post.class)
                .setParameter("types", types)
                .setParameter("countries", countries)
                .setParameter("categories", categories)
                .getResultList();

        return results;
    }
}

