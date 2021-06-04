package beyond.handong.se.repository;

import beyond.handong.se.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    /** PostRepository 는 아직 사용할 저장소가 특정되지 않았다는 가정하에 생성된 인터페이스이다.
     *  DB에 접근하고 관리 해야 하는데 나중에 JdbcTemplateRepository 를 쓰거나
     *  JpaRepository를 쓸 지 모르기 때문에 우선 필요할 것 같은 기능을 정의 해 놓고
     *  사용하는 것에 맞추어 구현을 하면 되겠다. - Jerome
     *
     *  기능 명세 :
     *  1. save post information to DB
     *  2. search by specific keyword ( user input )
     *  3. search by specific country filter
     *  4. retrieve among 4 categories
     *
     * */

    Post save(Post post);
    void edit(Post post);
    void delete(Long id);
    Optional<Post> findById(Long id);
    Optional<Post> findByTitle(String title);
    List<Post> findAll();
    List<Post> findBySector(String sector, List<String> countries, List<String> categories, String keyword);
    List<Post> findByWriterId(Long id);

}
