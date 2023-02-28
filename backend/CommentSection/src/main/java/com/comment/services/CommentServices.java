package com.comment.services;

import com.comment.exception.CommentException;
import com.comment.module.Comment;

public interface CommentServices {
	public Comment addComment(Comment comment) throws CommentException;
	
	public Comment addreplay(Integer commentid ,Comment comment) throws CommentException;
	
//	public Comment giveUpvote(Integer commentid) throws CommentException;
	
	public Comment giveDownvote(Integer commentid) throws CommentException;
	
	public Comment getCommentById(Integer commentid) throws CommentException;
}
