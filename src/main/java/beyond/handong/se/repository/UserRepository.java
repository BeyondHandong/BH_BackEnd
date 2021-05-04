package beyond.handong.se.repository;

import beyond.handong.se.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    /** UserRepository 는 아직 사용할 저장소가 특정되지 않았다는 가정하에 생성된 인터페이스이다.
     *  DB에 접근하고 관리 해야 하는데 나중에 JdbcTemplateRepository 를 쓰거나
     *  JpaRepository를 쓸 지 모르기 때문에 우선 필요할 것 같은 기능을 정의 해 놓고
     *  사용하는 것에 맞추어 구현을 하면 되겠다. - Jerome
     *
     *  기능 명세 :
     *  1. save  to DB
     *  2. retrieve unique ID, username, email address, studentID
     *  3. change password through editing profile setting
     *  4. [for admin] find all of users in DB
     *
     * */

    User save(User user);                       // save into database User table
    Optional<User> findById(Long id);           // using primary key
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findByStudentID(Long stuid);
    Optional<User> changePassword(String password);
    List<User> findAll();                       // Retrieving all Users

}
