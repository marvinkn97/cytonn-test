package dev.marvin.ticketbooking.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public List<User> getAllUsers(){
        return userDao.findAllUsers();
    }

    public User getUserById(Long userId){
        return userDao.findUserById(userId);
    }

    public User createUser(UserDto newUserRegistrationRequest){
        return null;
    }

    public User updateUser(Long userId, UserDto userUpdateRequest){
        return null;
    }

    public void deleteUserById(Long userId){}


}
