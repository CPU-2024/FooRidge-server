package CPU.FooRidge.controller;

import CPU.FooRidge.domain.User;
import CPU.FooRidge.repository.UserRepository;
import CPU.FooRidge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //read
    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAllUser();
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        User createUser = userService.addUser(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        User loggedUser=userService.login(user);
        if(loggedUser!=null) return new ResponseEntity<>(loggedUser,HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //유저삭제
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //유저 업데이트
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId,@RequestBody User updateUser){
        userService.updateUser(userId,updateUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //주소 업데이트
    @PutMapping("/{userId}/location")
    public ResponseEntity<User> updateAddress(@PathVariable("userId") Long userId,@RequestBody User updateAddress){
        userService.updateAddress(userId,updateAddress);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
