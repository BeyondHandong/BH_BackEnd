package beyond.handong.se.controller;

import beyond.handong.se.model.Scrap;
import beyond.handong.se.service.PostService;
import beyond.handong.se.service.ScrapService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ScrapController {

    private final ScrapService scrapService;
    private final PostService postService;

    public ScrapController(ScrapService scrapService, PostService postService) {
        this.scrapService = scrapService;
        this.postService = postService;
    }

    @PostMapping("scrap")
    @ResponseBody
    public Long myScrapPosts(Scrap scrap) {
        postService.editScrapNum(scrap.getPostId(), 1L);
        return scrapService.scrapPost(scrap);
    }

    @DeleteMapping("scrap")
    @ResponseBody
    public String deleteMyScrapPost(Scrap scrap) {
        scrapService.deleteScrapPost(scrap);
        return "deleted";
    }
}
