package com.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comment.module.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
