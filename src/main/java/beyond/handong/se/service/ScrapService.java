package beyond.handong.se.service;

import beyond.handong.se.model.Post;
import beyond.handong.se.model.Scrap;
import beyond.handong.se.repository.ScrapRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ScrapService {
    private final ScrapRepository scrapRepository;

    public ScrapService(ScrapRepository scrapRepository) {
        this.scrapRepository = scrapRepository;
    }

    public Long scrapPost(Scrap scrap) {
        scrapRepository.save(scrap);
        return scrap.getId();
    }
}
