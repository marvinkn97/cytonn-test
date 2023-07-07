package dev.marvin.ticketbooking.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
