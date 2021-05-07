package beyond.handong.se.controller;

import beyond.handong.se.model.Post;
import beyond.handong.se.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("post")
    @ResponseBody
    public List<Post> list(Model model) {
        List<Post> posts = postService.findPosts();
        model.addAttribute("members", posts);
        return posts;
    }
}

