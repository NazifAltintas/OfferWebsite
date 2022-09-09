package com.atom_v1.services.implementations;

import com.atom_v1.data.*;
import com.atom_v1.repository.CommentRepository;
import com.atom_v1.services.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;


    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;

    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
        if (commentRepository.findById(id).isPresent()) {

            return commentRepository.findById(id).get();
        }
        return new Comment();
    }

    @Override
    public List<Comment> getCommentsByUserEmail(String email) {
        List<Comment> commentList, comments;
        comments = commentRepository.findAll();
        commentList= new ArrayList<>();
        User userOfEmail;
        for (Comment comment : comments) {
           userOfEmail= comment.getUser();
            if (userOfEmail.getEmail().equals(email)) {
                commentList.add(comment);
            }
        }
        return commentList;
    }

    @Override
    public List<Comment> getCommentsByCompanyEmail(String email) {
        List<Comment> commentList, comments;
        comments = commentRepository.findAll();
        commentList= new ArrayList<>();
        Company companyOfEmail;
        for (Comment comment : comments) {
            companyOfEmail= comment.getCompany();
            if (companyOfEmail.getCompanyEmail().equals(email)) {
                commentList.add(comment);
            }
        }
        return commentList;
    }

    @Override
    public String createComment(Comment comment) {
        commentRepository.save(comment);
        if (commentRepository.existsById(comment.getCommentId())) return "comment is created successfully";
        return "comment couldn't  be created";
    }

    @Override
    public String deleteComment(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new IllegalStateException(id + " does not exist ");
        } else {
            commentRepository.deleteById(id);
            return "Comment with id is " + id + " is successfully deleted";
        }
    }


}

