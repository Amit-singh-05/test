package com.comment.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	
	private String comment;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer Upvotes = 0;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer Downvotes = 0;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private List<Comment> replays = new ArrayList<>();
	
}