package dev.marvin.ticketbooking.appuser;

import java.util.List;
import java.util.Optional;

interface UserDao {
    List<AppUser> findAllUsers();
    Optional<AppUser> findUserById(Long userId);
    AppUser save(AppUser appUser);
    void deleteUserById(Long userId);
    boolean existsUserWithEmail(String email);
}
