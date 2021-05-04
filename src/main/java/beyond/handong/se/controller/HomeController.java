package beyond.handong.se.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /** HomeController 는 웹페이지 도메인에서 "/" 를 입력 받았을 떄 할 동작을 정의한 부분
     *  ViewResolver 사용
     *
     * */

    @GetMapping("/")
    public String home(){
        return "index";   // "viewResolver가 index.html 찾아서 이동할 것
    }
}
