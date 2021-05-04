package beyond.handong.se.controller;

import beyond.handong.se.model.User;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {

    /** UserController는 사용자로부터 입력을 받을 Textfield라고 생각하면 된다.
     *  회원 가입시 기입해야 할 내용들이 주가 될 것이며, 학번 authentication 연동 후 form 형성은 좀 더 고민해봐야 함
     *  TODO : check if there is more need to get a input form later -Jerome
     * */

    private final User user;

    public UserController() {
        user = new User();
    }
}
