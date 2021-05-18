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
    Optional<User> findByName(String name);     // 특정 writer가 쓴 모든 글 조회
    Optional<User> findByEmail(String email);   // 특정 email 주소로 조회
    Optional<User> findByStudentID(Long stuid);         // 특정 학번으로 조회
    void changePassword(Long id, String password);      // 특정 id의 유저를 찾아서 그 패스워드를 변경시킴
    List<User> findAll();                       // Retrieving all Users

}
