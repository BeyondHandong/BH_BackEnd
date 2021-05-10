package beyond.handong.se.controller;

import beyond.handong.se.model.Post;
import beyond.handong.se.service.PostService;
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
    public List<Post> list(HttpServletRequest request, Model model) {
        List<Post> posts;

        if(request.getParameter("types") == null) posts = postService.findPosts();
        else {
            String[] types = request.getParameter("types").split(",");
            String[] countries = request.getParameter("countries").split(",");
            String[] categories = request.getParameter("category").split(",");
            posts = postService.findPosts(Arrays.asList(types), Arrays.asList(countries), Arrays.asList(categories));
        }

        return posts;
    }
    @PostMapping("post")
    @ResponseBody
    public String create(PostForm form) {
        Post post = new Post();
        post.setType(form.getType());
        post.setTitle(form.getTitle());
        post.setWriterId(form.getWriterId());
        post.setWriterName(form.getWriterName());
        post.setContent(form.getContent());

        post.setCategory(form.getCategory());
        post.setCountry(form.getCountry());

        post.setHelpfulNum(0l);
        post.setScrapNum(0l);
        post.setViewNum(0l);

        Date writeDate = new Date();
        post.setWriteDate(writeDate);
        post.setLastEditDate(writeDate);

        postService.join(post);

        return "redirect:/";
    }
}

