package beyond.handong.se.repository;

import beyond.handong.se.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByPost_Id(Long post_id);
}
