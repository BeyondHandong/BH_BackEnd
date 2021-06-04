package beyond.handong.se.service;

import beyond.handong.se.model.User;
import beyond.handong.se.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long join(User user){
        // 같은 이메일이 있는 중복 회원은 안된다.
        if(validateDuplicateMember(user)){
            return -1L;
        }
        if(!isHandongEmail(user.getEmail()))
            return -2L;
        return userRepository.save(user).getId();
    }

    private boolean isHandongEmail(String email){
        email = email.split("@")[1];
        return email.equals("handong.edu");
    }

    private boolean validateDuplicateMember(User user) {
        return userRepository.findByEmail(user.getEmail()).isPresent();
    }

    public Long validateUser(User user){
//        User exist =
        Optional<User> usr = userRepository.findByEmail(user.getEmail());
        if(usr.isPresent()){
            String password = usr.get().getPassword();
            if (user.getPassword().equals(password)) {
                return usr.get().getId();
            }
            return -2L;
        }
        return -1L;
    }

    /** TODO
     * user list 반환
     * */
    public List<User> listAll(){
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long id){
        return userRepository.findById(id);
    }


}
