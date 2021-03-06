package beyond.handong.se.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UserForm {

    /** UserForm은 사용자로부터 입력을 받을 Textfield라고 생각하면 된다.
     *  회원 가입시 기입해야 할 내용들이 주가 될 것이며, 학번 authentication 연동 후 form 형성은 좀 더 고민해봐야 함
     *  TODO : check if there is more need to get a input form later -Jerome
     * */

    private Long studentId;
    private Long password;
    private String name;

    @GetMapping("/signin")
    public String signInForm(){
        return "signIn";     // viewResolver가 NewPost.html 찾아서 이동할 것
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }
}
