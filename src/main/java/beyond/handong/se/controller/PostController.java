package beyond.handong.se.controller;

import beyond.handong.se.model.Post;
import beyond.handong.se.service.PostService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

        post.setHelpfulNum(0l);
        post.setScrapNum(0l);
        post.setViewNum(0l);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String writeDate = format.format(new Date());

        post.setWriteDate(writeDate);
        post.setLastEditDate(writeDate);

        System.out.println("DATE" + writeDate);

        postService.join(post);

        return "redirect:/";
    }

    @GetMapping("post/{post_id}")
    @ResponseBody
    public Optional<Post> aPost(@PathVariable("post_id") Long post_id) {
        return postService.findOne(post_id);
    }
    @PutMapping("post/{post_id}")
    @ResponseBody
    public String change(Post post, @PathVariable("post_id") Long post_id){
        post.setId(post_id);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String editDate = format.format(new Date());
        post.setLastEditDate(editDate);

        postService.update(post);

        return "redirect:/";
    }

    @GetMapping("post/info")
    @ResponseBody
    public List<Post> infoPosts(HttpServletRequest request, Model model) {
        String[] countries = {};
        if(request.getParameter("countries") != null)
            countries = request.getParameter("countries").split(",");

        String[] categories = {};
        if(request.getParameter("category") != null)
            categories = request.getParameter("category").split(",");

        return postService.findBySector("정보", Arrays.asList(countries), Arrays.asList(categories));
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