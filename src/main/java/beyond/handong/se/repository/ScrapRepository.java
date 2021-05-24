package beyond.handong.se.repository;

import beyond.handong.se.model.Post;
import beyond.handong.se.model.Scrap;

import java.util.List;

public interface ScrapRepository {
    Scrap save(Scrap scrap);
    void remove(Scrap scrap);
    List<Post> findByUserId(Long userId);
}
