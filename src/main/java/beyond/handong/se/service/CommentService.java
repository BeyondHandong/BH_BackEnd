package beyond.handong.se.service;

import beyond.handong.se.model.Comment;
import beyond.handong.se.repository.CommentRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Transactional
public class CommentService {
    private final CommentRepository commentRepository;

    EntityManager em;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findCommentsByPostId(Long post_id){
        return commentRepository.findCommentsByPost_Id(post_id);
    }

    public Long saveNewComment(Comment comment){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String writeDate = format.format(new Date());

        comment.setWriteDate(writeDate);

        commentRepository.save(comment);
        return comment.getId();
    }

    public void editComment(Comment comment){
        commentRepository.save(comment);
    }

    public void deleteComment(Long post_id){
        commentRepository.deleteByPostId(post_id);
    }
}
