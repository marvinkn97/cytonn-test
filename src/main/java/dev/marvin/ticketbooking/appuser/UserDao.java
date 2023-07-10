package dev.marvin.ticketbooking.appuser;

import java.util.List;

interface UserDao {
    List<AppUser> findAllUsers();
    AppUser findUserById(Long userId);
    AppUser save(AppUser appUser);
    void deleteUserById(Long userId);
    boolean existsUserWithEmail(String email);
}
