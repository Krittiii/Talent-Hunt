package com.code.talent.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.talent.models.Comments;
import com.code.talent.services.ICommentsService;

@RestController
@RequestMapping("api/comment/")
public class CommentsController {
	@Autowired
	ICommentsService commentService;
	
	@GetMapping(value = "/")
	public List<Comments> getAllComment(){
		return commentService.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public Comments getCommentById(@PathVariable("id") int id){
		return commentService.getById(id);
	}
	
	@PostMapping(value = "create")
	public Comments createComment(@RequestBody Comments comment){
		return commentService.add(comment);
	}
	
	@PutMapping(value = "edit")
	public Comments editComment(@RequestBody Comments comment){
		return commentService.update(comment);
	}
	
	@DeleteMapping(value = "delete/{id}")
	public String deleteComment(@PathVariable("id") int id){
		return commentService.delete(id);
	}
}
