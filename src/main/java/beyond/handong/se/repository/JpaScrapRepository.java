package beyond.handong.se.repository;

import beyond.handong.se.model.Post;
import beyond.handong.se.model.Scrap;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

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
        Optional<Scrap> result = em.createQuery("select s from Scrap s where s.postId = :pid and s.writerId = :uid", Scrap.class)
                .setParameter("pid", scrap.getPostId())
                .setParameter("uid",scrap.getWriterId())
                .getResultList()
                .stream().findAny();

        if(result.isPresent())
            em.remove(result.get());
    }

    @Override
    public List<Post> findByUserId(Long userId) {
        return em.createQuery("select p from Post p INNER join Scrap s On p.id=s.postId where s.writerId = :id order by p.writeDate desc", Post.class)
                .setParameter("id", userId)
                .getResultList();
    }
}
