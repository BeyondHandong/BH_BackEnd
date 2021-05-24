package beyond.handong.se.repository;

import beyond.handong.se.model.Scrap;

import javax.persistence.EntityManager;

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
}
