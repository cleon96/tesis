package uci.tesis.carlostesis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uci.tesis.carlostesis.entity.User;
import uci.tesis.carlostesis.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.createUser(user);
        return ResponseEntity.ok(user1);
    }
    @GetMapping("/userList")
    public ResponseEntity<List<User>> userList(){
        return ResponseEntity.ok(userService.userList());
    }
    @DeleteMapping("/deleteUser")
    public void deleteUser(Integer id){
        userService.deleteUser(id);
    }
}
