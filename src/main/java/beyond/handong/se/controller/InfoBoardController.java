package beyond.handong.se.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoBoardController {

    /** TODO: mapping information board (forum) to url
     *  TODO: change viewresolver method to handling responsebody object method
     * */

    @GetMapping("/informationBoard")        // viewResolver 방식
    public String InfoBoard(){
        return "informationBoard";   // "viewResolver가 informationBoard.html 찾아서 이동할 것
    }


}
