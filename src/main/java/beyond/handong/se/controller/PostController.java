package beyond.handong.se.controller;

import beyond.handong.se.model.Helpful;
import beyond.handong.se.model.Post;
import beyond.handong.se.service.PostService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public Long create(@RequestBody Post post) {

        post.setHelpfulNum(0l);
        post.setScrapNum(0l);
        post.setViewNum(0l);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.HOUR, 9);
        String writeDate = format.format(cal.getTime());


        post.setWriteDate(writeDate);
        post.setLastEditDate(writeDate);

        System.out.println("DATE" + writeDate);

        return postService.join(post);
    }

    @GetMapping("post/{post_id}")
    @ResponseBody
    public Optional<Post> aPost(@PathVariable("post_id") Long post_id) {
        return postService.findOne(post_id);
    }

    @PutMapping("post/{post_id}")
    @ResponseBody
    public String change(@RequestBody Post post, @PathVariable("post_id") Long post_id){
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

        String searchKeyWord = "";
        if(request.getParameter("search") != null)
            searchKeyWord = request.getParameter("search");

        return postService.findBySector("??????", Arrays.asList(countries), Arrays.asList(categories), searchKeyWord);
    }

    @GetMapping("post/free")
    @ResponseBody
    public List<Post> freePosts(HttpServletRequest request, Model model) {
        String[] countries = {};
        if(request.getParameter("countries") != null)
            countries = request.getParameter("countries").split(",");

        String[] categories = {};
        if(request.getParameter("category") != null)
            categories = request.getParameter("category").split(",");

        String searchKeyWord = "";
        if(request.getParameter("search") != null)
            searchKeyWord = request.getParameter("search");

        return postService.findBySector("??????", Arrays.asList(countries), Arrays.asList(categories), searchKeyWord);
    }

    @GetMapping("post/my/{user_id}")
    @ResponseBody
    public List<Post> myPosts(@PathVariable("user_id") Long user_id) {
        return postService.findMyPosts(user_id);
    }

    @DeleteMapping("post/{post_id}")
    @ResponseBody
    public void deleteAPost(@PathVariable("post_id") Long post_id){
        postService.delete(post_id);
    }

    @PutMapping("post/helpful")
    @ResponseBody
    public void updatePostHelpfulNum(@RequestBody Helpful helpful){
        postService.updateHelpful(helpful);
    }

    @GetMapping("post/helpful/{post_id}/{user_id}")
    @ResponseBody
    public Map isHelpful(@PathVariable("post_id") Long post_id, @PathVariable("user_id") Long user_id){
        Map result = new HashMap<String, Object>();

        result.put("isHelpful", Boolean.toString(postService.isHelpful(post_id, user_id)));

        return result;
    }


}