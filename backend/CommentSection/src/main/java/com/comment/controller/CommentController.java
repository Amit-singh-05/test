package com.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comment.exception.CommentException;
import com.comment.module.Comment;
import com.comment.services.CommentServices;

@RestController
@RequestMapping("/commentController")
public class CommentController {
	@Autowired
	private CommentServices commentServices;
	
	@CrossOrigin
	@PostMapping("/addComment")
	public ResponseEntity<Comment> addCommentHandler(@RequestBody Comment comment) throws CommentException{
		
		Comment addedcomment = commentServices.addComment(comment);

		return new ResponseEntity<Comment>(addedcomment, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/addreplay")
	public ResponseEntity<Comment> addreplayHandler(@RequestBody Comment comment, @RequestParam("commentid") Integer commentid) throws CommentException {

		Comment addedreplay = commentServices.addreplay(commentid, comment);
		
		return new ResponseEntity<Comment>(addedreplay, HttpStatus.OK);

	}
	
//	@CrossOrigin
//	@PutMapping("/giveUpvote")
//	public ResponseEntity<Comment> giveUpvoteHandler(@RequestParam("commentid") Integer commentid) throws CommentException {
//
//		Comment addedreplay = commentServices.giveUpvote(commentid);
//		
//		return new ResponseEntity<Comment>(addedreplay, HttpStatus.OK);
//
//	}
//	
	@CrossOrigin
	@PutMapping("/giveDownvote")
	public ResponseEntity<Comment> giveDownvoteHandler(@RequestParam("commentid") Integer commentid) throws CommentException {

		Comment addedreplay = commentServices.giveDownvote(commentid);
		
		return new ResponseEntity<Comment>(addedreplay, HttpStatus.OK);

	}
	
	@CrossOrigin
	@GetMapping("/getcomment")
	public ResponseEntity<Comment> getCommentHandler(@RequestParam("commentid") Integer commentid) throws CommentException {

		Comment comment = commentServices.giveDownvote(commentid);
		
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);

	}
}