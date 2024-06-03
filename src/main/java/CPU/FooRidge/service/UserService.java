package CPU.FooRidge.service;

import CPU.FooRidge.domain.User;
import CPU.FooRidge.dto.user.AddUserRequest;
import CPU.FooRidge.dto.user.LoginUserRequest;
import CPU.FooRidge.dto.user.UpdateUserRequest;
import CPU.FooRidge.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
    public User addUser(AddUserRequest dto){
        return userRepository.save(dto.toEntity());
    }

    public void uploadProFile(Long userId, MultipartFile file){
        User user=userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("Not found user:"+userId));
            try{
                String projectPath = System.getProperty("user.dir")
                        + "\\src\\main\\resources\\static\\files";

                UUID uuid = UUID.randomUUID();

                // UUID와 파일이름을 포함된 파일 이름 저장
                String fileName = uuid + "_" + file.getOriginalFilename();

                // projectPath는  경로, name은 전달받을 이름
                File saveFile = new File(projectPath, fileName);

                file.transferTo(saveFile);

                user.updateUserFile(fileName, "/files/" + fileName);
                userRepository.save(user);
            }catch (IOException e) {
                e.printStackTrace();
            }
    }

    public User login(LoginUserRequest dto) {
        User loggedUser = userRepository.findByUserEmail(dto.getUserEmail());
        if (loggedUser != null && isPasswordValid(dto.getUserPassword(), loggedUser.getUserPassword()))
            return loggedUser;
       return null;
    }
    private boolean isPasswordValid(String inputPassword,String storedPassword){
        return inputPassword.equals(storedPassword);
    }
    //유저 삭제
    public void deleteUser(Long userId){
         userRepository.deleteById(userId);
    }

    public User updateUser(Long userId,UpdateUserRequest dto){
        User user=userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("Not found user:"+userId));
        if(user==null) return null;
        user.update(dto.getUserName(),
                    dto.getUserEmail(),
                    dto.getUserAddress());
        return userRepository.save(user);
    }

    @Transactional
    public User updateUserAddress(Long userId,UpdateUserRequest dto) {
        User user=userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("Not found user:"+userId));
        user.updateAddress(dto.getUserAddress());
        return userRepository.save(user);
    }
}
