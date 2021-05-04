package beyond.handong.se.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WritingPostForm {

    /** TODO: mapping writing a post to board connecting to web url
     *  TODO: change view resolver method to handling responsebody object method
     * */

    @GetMapping("/writingPost")
    public String NewPost(){
        return "NewPost";        // viewResolver가 NewPost.html 찾아서 이동할 것
    }

}
