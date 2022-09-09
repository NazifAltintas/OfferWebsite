package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

    Comment getCommentById(Long id);

    List<Comment> getCommentsByUserEmail(String email);

    List<Comment> getCommentsByCompanyEmail(String email);

    String createComment(Comment comment);

    String deleteComment(Long id);
}
