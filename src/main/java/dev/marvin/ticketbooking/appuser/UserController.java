package dev.marvin.ticketbooking.appuser;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "AppUser API v1")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @Operation(summary = "Get All Users")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<AppUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Get AppUser By ID")
    @GetMapping("/{userId}")
    public ResponseEntity<AppUser> getUserById(@PathVariable("userId") Long userId) {
        AppUser appUser = userService.getUserById(userId);
        return ResponseEntity.ok(appUser);
    }

    @Operation(summary = "Create New AppUser")
    @PostMapping
    public ResponseEntity<AppUser> createUser(@Validated @RequestBody UserDto newUserRegistrationRequest){
        AppUser createdAppUser = userService.createUser(newUserRegistrationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAppUser);
    }
}
