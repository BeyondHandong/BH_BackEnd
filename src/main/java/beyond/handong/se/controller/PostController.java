package beyond.handong.se.controller;

import beyond.handong.se.model.Post;
import beyond.handong.se.service.PostService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
    public List<Post> allPosts(Model model) {
        return postService.findPosts();
    }
    @PostMapping("post")
    @ResponseBody
    public String create(Post post) {

        postService.join(post);

        return "redirect:/";
    }

    @GetMapping("post/info")
    @ResponseBody
    public List<Post> infoPosts(HttpServletRequest request, Model model) {
        List<Post> posts;

        String[] countries = request.getParameter("countries").split(",");
        String[] categories = request.getParameter("category").split(",");
        posts = postService.findBySector("정보", Arrays.asList(countries), Arrays.asList(categories));

        return posts;
    }

    @GetMapping("post/free")
    @ResponseBody
    public List<Post> freePosts(HttpServletRequest request, Model model) {
        List<Post> posts;

        String[] countries = request.getParameter("countries").split(",");
        String[] categories = request.getParameter("category").split(",");
        posts = postService.findBySector("자유", Arrays.asList(countries), Arrays.asList(categories));

        return posts;
    }
}

