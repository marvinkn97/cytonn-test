package dev.marvin.ticketbooking.user;

import java.util.List;

interface UserDao {
    List<User> findAllUsers();
    User findUserById(Long userId);
    User save(User user);
    void deleteUserById(Long userId);
    User existsUserWithEmail(String email);
}
