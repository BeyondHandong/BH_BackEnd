package beyond.handong.se.controller;

import beyond.handong.se.model.Post;
import beyond.handong.se.model.User;
import beyond.handong.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class UserController {

    /** UserController는 사용자로부터 입력을 받을 Textfield라고 생각하면 된다.
     *  회원 가입시 기입해야 할 내용들이 주가 될 것이며, 학번 authentication 연동 후 form 형성은 좀 더 고민해봐야 함
     *  TODO : check if there is more need to get a input form later -Jerome
     * */

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/all")
    @ResponseBody
    public List<User> findAll(User user) {
        return userService.listAll();
    }

    @PostMapping("user/new")
    @ResponseBody
    public String signIn(User user) {

//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//        String register_Date = format.format(new Date());

        user.setRegisterDate(new Date());

        userService.join(user);

        return "redirect:/";
    }

}
