package beyond.handong.se.controller;

import beyond.handong.se.model.Comment;
import beyond.handong.se.model.Post;
import beyond.handong.se.service.CommentService;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("comment/{post_id}")
    @ResponseBody
    public List<Comment> allPosts(@PathVariable("post_id") Long post_id) {
        return commentService.findCommentsByPostId(post_id);
    }

    @PostMapping("comment")
    @ResponseBody
    public Long saveComment(Comment comment) {
        System.out.println(comment.getPostId() + " " + comment.getContent());
        return commentService.saveNewComment(comment);
    }

    @PutMapping("comment")
    @ResponseBody
    public void editComment(Comment comment) {
        commentService.editComment(comment);
    }
}
