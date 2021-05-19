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

    /** TODO
     * 회원 가입    => Done
     * 로그인
     * */
    public Long join(User user){
        // 같은 이름이 있는 중복 회원은 안된다.
        validateDuplicateMember(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateMember(User user) {
        userRepository.findByEmail(user.getEmail())
                // 바로 get 써서 꺼내는 것 대신 아래와 같이 if문으로 null 예외처리 하는걸 권장.
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public Long validateUser(User user){
//        User exist =
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            String password = user.getPassword();
            if (user.getPassword().equals(password))
                return user.getId();
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
