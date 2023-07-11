package dev.marvin.ticketbooking.appuser;

import dev.marvin.ticketbooking.exception.DuplicateResourceException;
import dev.marvin.ticketbooking.exception.RequestValidationException;
import dev.marvin.ticketbooking.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;
//    private final PasswordEncoder passwordEncoder;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }

    public List<AppUser> getAllUsers(){
        return userDao.findAllUsers();
    }

    public AppUser getUserById(Long userId){
        return userDao.findUserById(userId).orElseThrow(() -> new ResourceNotFoundException("user with id [%s] not found".formatted(userId)));
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

        AppUser appUser = userDao.findUserById(userId).orElseThrow(() -> new ResourceNotFoundException("user with id [%s] not found".formatted(userId)));

        boolean changes = false;

        if (userDao.existsUserWithEmail(userUpdateRequest.email())) {
            throw new DuplicateResourceException("email already taken");
        }

        if (!userUpdateRequest.fullName().equals(appUser.getFullName())) {
            appUser.setFullName(userUpdateRequest.fullName());
            changes = true;
        }

        if (!userUpdateRequest.email().equals(appUser.getEmail())) {
            appUser.setEmail(userUpdateRequest.email());
            changes = true;
        }

        if (!userUpdateRequest.password().equals(appUser.getPassword())) {
            appUser.setPassword(userUpdateRequest.password());
            changes = true;
        }

        if (!userUpdateRequest.address().equals(appUser.getAddress())) {
            appUser.setAddress(userUpdateRequest.address());
            changes = true;
        }

        if (!changes) {
            throw new RequestValidationException("no data changes found");
        }

        return userDao.save(appUser);
    }

    public void deleteUserById(Long userId){
        userDao.deleteUserById(userId);
    }

}
