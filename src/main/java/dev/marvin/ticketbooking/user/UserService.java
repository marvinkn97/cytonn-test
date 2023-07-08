package dev.marvin.ticketbooking.user;

import dev.marvin.ticketbooking.exception.DuplicateResourceException;
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

       if(userDao.existsUserWithEmail(newUserRegistrationRequest.email())){
           throw new DuplicateResourceException("email already taken");
       }

       User newUser = User.builder()
               .fullName(newUserRegistrationRequest.fullName())
               .email(newUserRegistrationRequest.email())
               .password(newUserRegistrationRequest.password())
               .phoneNumber(newUserRegistrationRequest.phoneNumber())
               .address(newUserRegistrationRequest.address())
               .build();

        return userDao.save(newUser);
    }

    public User updateUser(Long userId, UserDto userUpdateRequest){
        return null;
    }

    public void deleteUserById(Long userId){}


}
