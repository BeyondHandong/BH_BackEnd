package beyond.handong.se.service;

import beyond.handong.se.model.User;
import beyond.handong.se.repository.UserRepository;

import java.util.List;
import java.util.Optional;


public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /** TODO
     * 회원 가입
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
    /** TODO
     * 관리자 가입(?)
     * authentication을 어떻게 해야 할지..
     * giveAuth(User user) 같은 걸로 만드는 것도 괜찮겠다.
     * */

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
