package beyond.handong.se.controller;

import beyond.handong.se.model.Post;
import beyond.handong.se.model.Scrap;
import beyond.handong.se.service.ScrapService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class ScrapController {

    private final ScrapService scrapService;

    public ScrapController(ScrapService scrapService) {
        this.scrapService = scrapService;
    }

    @PostMapping("post/scrap")
    @ResponseBody
    public Long myScrapPosts(Scrap scrap) {
        return scrapService.scrapPost(scrap);
    }
}
