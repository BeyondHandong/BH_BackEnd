package beyond.handong.se.repository;

import beyond.handong.se.model.Helpful;
import beyond.handong.se.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Arrays;
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
    public void edit(Post post) {
        em.merge(post);
    }

    @Override
    public void delete(Long post_id){
        em.remove(em.find(Post.class, post_id));
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
    public List<Post> findBySector(String sector, List<String> countries, List<String> categories, String keyword) {
        if(countries.isEmpty())
            countries = em.createQuery("select distinct m.country from Post m").getResultList();

        if(categories.isEmpty())
            categories = em.createQuery("select distinct m.category from Post m").getResultList();

        keyword = "%" + keyword + "%";

        List<String> keywords = Arrays.asList(keyword.split(","));

        List<Post> results = em.createQuery("select m from Post m where m.title like :keyword and m.sector = :sector and m.country in :countries and m.category in :categories", Post.class)
                .setParameter("keyword", keyword)
                .setParameter("sector", sector)
                .setParameter("countries", countries)
                .setParameter("categories", categories)
                .getResultList();

        return results;
    }

    public List<Post> findByWriterId(Long id){
        return em.createQuery("select m from Post m where m.writerId = :id", Post.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public Optional<Helpful> findHelpfuById(Helpful helpful) {
        Optional<Helpful> result = em.createQuery("select h from Helpful h where h.postId = :pid and h.userId = :uid", Helpful.class)
                .setParameter("pid", helpful.getPostId())
                .setParameter("uid", helpful.getUserId())
                .getResultList()
                .stream().findAny();

        return result;
    }

    @Override
    public void newHelpful(Helpful helpful) {
        em.persist(helpful);
    }

    @Override
    public void deleteHelpful(Helpful helpful) {
        em.remove(em.contains(helpful) ? helpful : em.merge(helpful));
    }
}