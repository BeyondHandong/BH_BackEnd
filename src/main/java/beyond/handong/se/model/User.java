package beyond.handong.se.model;

import java.util.ArrayList;
import java.util.Date;

public class User {

    private Long id;    // primary key
    private Long studentId;
    private String name;
    private String password;
    private String email;
    private Date registerDate;
    private Date lastLogInDate;
    private short authKey;
    private Long loginCount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastLogInDate() {
        return lastLogInDate;
    }

    public void setLastLogInDate(Date lastLogInDate) {
        this.lastLogInDate = lastLogInDate;
    }

    public short getAuthKey() {
        return authKey;
    }

    public void setAuthKey(short authKey) {
        this.authKey = authKey;
    }

    public Long getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Long loginCount) {
        this.loginCount = loginCount;
    }
}
