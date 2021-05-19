package beyond.handong.se.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class User {

    /** User domain은 User 정보가 담을 수 있는 정보들을 의미한다.
     * 1. unique ID (primary key)
     * 2. student Num Long
     * 3. password String
     * 4. name String
     * 5. email String
     * 6. register date Date
     * */


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)     // DB will generate id automatically
    private Long id;    // primary key
    private Long studentId;
    private String name;
    private String password;
    private String email;
    private Date registerDate;

    // 얘네 일단 보류. 따로 model을 만들지 or List로 만들어서 같이 관리 할 지.
/*
    private Date lastLogInDate;
    private short authKey;
    private Long loginCount;

    */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
