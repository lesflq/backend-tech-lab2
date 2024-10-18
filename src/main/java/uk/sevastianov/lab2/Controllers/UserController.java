package uk.sevastianov.lab2.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uk.sevastianov.lab2.Entity.User;
import uk.sevastianov.lab2.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable(name = "userId") Long userId) {
        return userService.getUser(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "userId") Long userId) {
        if (userService.deleteUser(userId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}