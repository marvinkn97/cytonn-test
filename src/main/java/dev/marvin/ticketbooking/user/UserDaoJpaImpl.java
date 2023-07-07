package dev.marvin.ticketbooking.user;

import dev.marvin.ticketbooking.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Primary
public class UserDaoJpaImpl implements UserDao{
    private final UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findUserById(userId).orElseThrow(() -> new ResourceNotFoundException("user with id [%s] not found".formatted(userId)));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User existsUserWithEmail(String email) {
        return ;
    }

}
