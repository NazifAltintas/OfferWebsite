package com.atom_v1.services.implementations;

import com.atom_v1.data.Comment;
import com.atom_v1.data.MasterCompany;
import com.atom_v1.data.User;
import com.atom_v1.services.interfaces.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public Comment getCommentById(Long id) {
        return null;
    }

    @Override
    public List<Comment> getCommentsByUser(User user) {
        return null;
    }

    @Override
    public List<Comment> getCommentsByCompany(MasterCompany company) {
        return null;
    }

    @Override
    public void createComment(Comment comment) {

    }

    @Override
    public void deleteComment(Comment comment) {

    }
}
