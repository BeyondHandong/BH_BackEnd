package beyond.handong.se.controller;

import beyond.handong.se.model.Post;
import beyond.handong.se.model.User;
import beyond.handong.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;


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

    @GetMapping("user")
    @ResponseBody
    public List<User> findAll(User user) {
        return userService.listAll();
    }


    @GetMapping("user/profile/{user_id}")
    @ResponseBody
    public Optional<User> findAnUser(@PathVariable("user_id") Long user_id){
        return userService.findOne(user_id);
    }

    // 패스워드 검증. isUserIndB 이런 걸로
    @PostMapping("user/signup")
    @ResponseBody
    public String signUp(@RequestBody User user) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String writeDate = format.format(new Date());

        user.setRegisterDate(writeDate);
        user.setAuthKey(0);     // 일반 유저는 0의 auth를 가짐.
        // 이미 중복회원이 있을 때
        if(userService.join(user) == -1L){
            return "The email is already existed!";
        }

        return "redirect:/";
    }

    @PostMapping("user/signin")
    @ResponseBody
    public Map isValidUser(@RequestBody User user){
        Map result = new HashMap<String, Long>();
        result.put("user_id",userService.validateUser(user));
        return result;
    }
}
