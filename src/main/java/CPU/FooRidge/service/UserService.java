package CPU.FooRidge.service;

import CPU.FooRidge.domain.User;
import CPU.FooRidge.dto.user.AddUserRequest;
import CPU.FooRidge.dto.user.LoginUserRequest;
import CPU.FooRidge.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    public void uploadProFile(Long userId,MultipartFile file)throws Exception{
//        Optional<User> userOptional = userRepository.findById(userId);
//            try{
//                String projectPath = System.getProperty("user.dir")
//                        + "\\src\\main\\resources\\static\\files";
//
//                UUID uuid = UUID.randomUUID();
//
//                // UUID와 파일이름을 포함된 파일 이름 저장
//                String fileName = uuid + "_" + file.getOriginalFilename();
//
//                // projectPath는  경로, name은 전달받을 이름
//                File saveFile = new File(projectPath, fileName);
//
//                file.transferTo(saveFile);
//
//                userRepository.findById(userId).ifPresent(user -> {
//                    user.setUserFileName(fileName);
//                    user.setUserFilePath("/files/" + fileName);
//                    userRepository.save(user);
//                });
//            }catch (IOException e) {
//                e.printStackTrace();
//            }
//    }

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

//    public User updateUser(Long userId,User updatedUser){
//        Optional<User> userOptional = userRepository.findById(userId);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            user.setUserName(updatedUser.getUserName());
//            user.setUserPassword(updatedUser.getUserPassword());
//            return userRepository.save(user);
//        }
//        return null;
//    }
//
//    public User updateUserAddress(Long userId, String newAddress) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            user.setUserAddress(newAddress);
//            return userRepository.save(user);
//        }
//        return null;
//    }
}
