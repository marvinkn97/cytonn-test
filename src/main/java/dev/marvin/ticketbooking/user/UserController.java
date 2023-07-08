package dev.marvin.ticketbooking.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User API v1")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @Operation(summary = "Get All Users")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Get User By ID")
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Create New User")
    @PostMapping
    public ResponseEntity<User> createUser(@Validated @RequestBody UserDto newUserRegistrationRequest){
        User createdUser = userService.createUser(newUserRegistrationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
