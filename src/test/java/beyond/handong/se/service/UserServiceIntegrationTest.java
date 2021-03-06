package beyond.handong.se.service;

import beyond.handong.se.model.User;
import beyond.handong.se.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class UserServiceIntegrationTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void 회원가입() throws Exception{
        // given
        User user = new User();
        user.setName("Handong");
        user.setStudentId("2140749");
        user.setEmail("2140749@handong.edu");
        // when
        Long savedId = userService.join(user);

        // then
        User findUser1 = userService.findOne(savedId).get();
        assertThat(user.getStudentId()).isEqualTo(findUser1.getStudentId());
    }

    @Test
    public void 중복_회원_예외(){
        // given
        User user = new User();
        user.setEmail("beyond@handong.edu");

        User user2 = new User();
        user2.setEmail("beyond@handong.edu");

        // when
        userService.join(user);
        assertThat(userService.join(user2)).isEqualTo(-1L);
    }

}
