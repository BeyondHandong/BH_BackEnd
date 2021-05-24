package beyond.handong.se.repository;

import beyond.handong.se.model.Post;
import beyond.handong.se.model.Scrap;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaScrapRepository implements ScrapRepository{
    private EntityManager em;

    public JpaScrapRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Scrap save(Scrap scrap) {
        em.persist(scrap);
        return scrap;
    }

    @Override
    public void remove(Scrap scrap){
        em.remove(scrap);
    }

    @Override
    public List<Post> findByUserId(Long userId) {
        return em.createQuery("select p from Post p INNER join Scrap s On p.writerId=s.writerId AND p.id=s.postId where p.writerId = :id", Post.class)
                .setParameter("id", userId)
                .getResultList();
    }
}
