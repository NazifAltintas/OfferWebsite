package com.atom_v1.services.implementations;

import com.atom_v1.data.*;
import com.atom_v1.repository.*;
import com.atom_v1.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private CommentRepository commentRepository;
    private TaskRepository taskRepository;
    private CompanyRepository companyRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CommentRepository commentRepository,
                           TaskRepository taskRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        }
        return new User();
    }

    @Override
    public User getUserByEmail(String email) {
        if (userRepository.findUserByEmail(email).isPresent()) {
            return userRepository.findUserByEmail(email).get();
        }
        return new User();
    }

    @Override
    public User getUserByCommentId(Long id) {
        if (commentRepository.findById(id).isPresent()) {
            Comment comment = commentRepository.findById(id).get();
            return comment.getUser();
        }
        return new User();
    }

    @Override
    public User getUserByTaskId(Long id) {
        if (taskRepository.findById(id).isPresent()) {
            Task task = taskRepository.findById(id).get();
            return task.getUserDetails();
        }
        return new User();
    }

    @Override
    public User getUserByCompanyName(String name) {
        return null;
    }


    @Override
    public String createUser(User user) {
        userRepository.save(user);
        if (userRepository.existsById(user.getUserId())) return "user is created successfully";
        return "user couldn't  be created";
    }

    @Override
    public String deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalStateException(id + " does not exist ");
        } else {
            userRepository.deleteById(id);
            return "user with id is " + id + " is successfully deleted";
        }
    }


}
