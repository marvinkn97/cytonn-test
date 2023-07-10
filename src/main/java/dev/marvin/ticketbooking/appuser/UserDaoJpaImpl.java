package dev.marvin.ticketbooking.appuser;

import dev.marvin.ticketbooking.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class UserDaoJpaImpl implements UserDao{
    private final UserRepository userRepository;

    @Override
    public List<AppUser> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public AppUser findUserById(Long userId) {
        return userRepository.findUserById(userId).orElseThrow(() -> new ResourceNotFoundException("appuser with id [%s] not found".formatted(userId)));
    }

    @Override
    public AppUser save(AppUser appUser) {
        return userRepository.save(appUser);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public boolean existsUserWithEmail(String email) {
        return userRepository.findUserByEmail(email) ;
    }

}
