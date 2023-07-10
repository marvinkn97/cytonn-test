package dev.marvin.ticketbooking.appuser;

import dev.marvin.ticketbooking.exception.DuplicateResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public List<AppUser> getAllUsers(){
        return userDao.findAllUsers();
    }

    public AppUser getUserById(Long userId){
        return userDao.findUserById(userId);
    }

    public AppUser createUser(UserDto newUserRegistrationRequest){

       if(userDao.existsUserWithEmail(newUserRegistrationRequest.email())){
           throw new DuplicateResourceException("email already taken");
       }

       AppUser newAppUser = AppUser.builder()
               .fullName(newUserRegistrationRequest.fullName())
               .email(newUserRegistrationRequest.email())
               .password(newUserRegistrationRequest.password())
               .phoneNumber(newUserRegistrationRequest.phoneNumber())
               .address(newUserRegistrationRequest.address())
               .build();

        return userDao.save(newAppUser);
    }

    public AppUser updateUser(Long userId, UserDto userUpdateRequest){

        AppUser appUser = userDao.findUserById(userId);

        if(userDao.existsUserWithEmail(userUpdateRequest.email())){
            throw new DuplicateResourceException("email already taken");
        }

        appUser.setFullName(userUpdateRequest.fullName());
        appUser.setEmail(userUpdateRequest.email());
        appUser.setPassword(userUpdateRequest.password());



        return null;
    }

    public void deleteUserById(Long userId){
        userDao.deleteUserById(userId);
    }


}
