package com.comment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comment.exception.CommentException;
import com.comment.module.Comment;
import com.comment.repository.CommentRepo;

@Service
public class CommentServicesImpl implements CommentServices{
	@Autowired
	private CommentRepo commentRepo;

	@Override
	public Comment addComment(Comment comment) throws CommentException{
		Optional<Comment> cot = commentRepo.findById(comment.getCommentId());
		if(cot.isEmpty()) {
			return commentRepo.save(comment);
		}else {
			throw new CommentException("comment with this comment id already present");
		}
	}

	@Override
	public Comment addreplay(Integer commentid, Comment comment) throws CommentException{
		Optional<Comment> cot = commentRepo.findById(commentid);
		if(cot.isEmpty()) {
			throw new CommentException("comment with this comment id not present");
		}else {
			Comment comm = cot.get();
			comm.getReplays().add(comment);
			commentRepo.save(comm);
			return comm;
		}
	}

//	@Override
//	public Comment giveUpvote(Integer commentid ) throws CommentException{
//		Optional<Comment> cot = commentRepo.findById(commentid);
//		if(cot.isEmpty()) {
//			throw new CommentException("comment with this comment id not present");
//		}else {
//			Comment comm = cot.get();
//			comm.setUpvotes(comm.getUpvotes()+1);
//			commentRepo.save(comm);
//			return comm;
//		}
//	}

	@Override
	public Comment giveDownvote(Integer commentid) throws CommentException{
		Optional<Comment> cot = commentRepo.findById(commentid);
		if(cot.isEmpty()) {
			throw new CommentException("comment with this comment id not present");
		}else {
			Comment comm = cot.get();
			comm.setUpvotes(comm.getUpvotes()+1);
			commentRepo.save(comm);
			return comm;
		}
	}

	@Override
	public Comment getCommentById(Integer commentid) throws CommentException {
		Optional<Comment> cot = commentRepo.findById(commentid);
		if(cot.isEmpty()) {
			throw new CommentException("comment with this comment id not present");
		}else {
			Comment comm = cot.get();
			return comm;
		}
	}

}