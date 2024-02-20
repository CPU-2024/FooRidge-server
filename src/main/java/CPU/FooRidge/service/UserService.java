package CPU.FooRidge.service;

import CPU.FooRidge.domain.User;
import CPU.FooRidge.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    @Transactional
    public User addUser(User user){
        return userRepository.save(user);
    }

    public User login(User user) {
        User loggedUser = userRepository.findByUserEmail(user.getUserEmail());
        if (loggedUser != null && loggedUser.getUserPassword().equals(user.getUserPassword())) {
            return loggedUser;
        } else {
            return null;
        }
    }

    //유저 삭제
    public void deleteUser(Long userId){
         userRepository.deleteById(userId);
    }

    public User updateUser(Long userId,User updatedUser){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUserName(updatedUser.getUserName());
            user.setUserPassword(updatedUser.getUserPassword());
            user.setUserAddress(updatedUser.getUserAddress());
            return userRepository.save(user);
        }
        return null;
    }

}
