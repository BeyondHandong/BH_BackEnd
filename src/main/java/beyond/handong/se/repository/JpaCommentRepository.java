package beyond.handong.se.repository;

import beyond.handong.se.model.Comment;
import beyond.handong.se.model.Post;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaCommentRepository implements CommentRepository{
    EntityManager em;

   public JpaCommentRepository(EntityManager em){
       this.em = em;
   }

    @Override
    public List<Comment> findCommentsByPost_Id(Long post_id) {
        return em.createQuery("select c from Comment c where c.postId = :post_id", Comment.class)
                .setParameter("post_id", post_id)
                .getResultList();
    }

    @Override
    public Comment save(Comment comment) {
        em.persist(comment);
        return comment;
    }

    @Override
    public Comment edit(Comment comment) {
        em.merge(comment);
        return comment;
    }
}
