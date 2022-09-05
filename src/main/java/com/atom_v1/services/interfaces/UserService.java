package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByOffer(Offer offer);

    User getUserByComment(Comment comment);

    User getUserByTask(Task task);

    User getUserByCompany(MasterCompany company);

    void createUser(User user);

    void deleteUser(User user);
}
