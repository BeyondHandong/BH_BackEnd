package beyond.handong.se.repository;

import beyond.handong.se.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class JpaUserRepository implements UserRepository{

    private EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByName(String name) {
        List<User> result = em.createQuery("select m from User m where m.name = :name", User.class)
                .setParameter("name", name)
                .getResultList();
//        User user = em.find(User.class, name);
//        return Optional.ofNullable(user);
        return result.stream().findAny();
    }

    @Override
    public Optional<User> findByEmail(String email) {
//        User user = em.find(User.class, email);
//        return Optional.ofNullable(user);
        List<User> result = em.createQuery("select m from User m where m.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<User> findByStudentID(String stuid) {
//        User user = em.find(User.class, stuid);
//        return Optional.ofNullable(user);
        List<User> result = em.createQuery("select m from User m where m.studentId = :studentId", User.class)
                .setParameter("studentId", stuid)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public void changePassword(Long id, String password) {
        User user = em.find(User.class, id);
        user.setPassword(password);

//        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        List<User> userList = em.createQuery("select m from User m", User.class ).getResultList();
        return userList;
    }
}
