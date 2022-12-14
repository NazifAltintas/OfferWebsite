package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByEmail(String email);

    User getUserByCommentId(Long id);

    User getUserByTaskId(Long id);

    User getUserByCompanyName(String name);

    String createUser(User user);

    String deleteUser(Long id);
}
