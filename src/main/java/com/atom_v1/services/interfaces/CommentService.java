package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

    Comment getCommentById(Long id);

    List<Comment> getCommentsByUser(User user);

    List<Comment> getCommentsByCompany(MasterCompany company);

    void createComment(Comment comment);

    void deleteComment(Comment comment);
}
