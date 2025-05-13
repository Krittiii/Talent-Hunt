package com.code.talent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.talent.models.Comments;

import com.code.talent.repositories.ICommentsRepository;

@Service

public class CommentsService implements ICommentsService
{
	@Autowired
	ICommentsRepository commentsRepository;
	@Override
	public Comments add(Comments comments) {
		// TODO Auto-generated method stub
		
		return commentsRepository.save(comments);
	}

	@Override
	public Comments update(Comments comments) {
		// TODO Auto-generated method stub
		return commentsRepository.save(comments);
	}

	@Override
	public String delete(Comments comments) {
		// TODO Auto-generated method stub
		commentsRepository.delete(comments);
		return "Record is deleted";
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		Comments comments=commentsRepository.findById(id).get();
		if(comments==null)
		{
			return "Talent  with Id "+id+" not found";
		}
		commentsRepository.delete(comments);
		return "Record is deletd";
	
	}

	@Override
	public List<Comments> getAll() {
		// TODO Auto-generated method stub
		return commentsRepository.findAll();
	}

	@Override
	public Comments getById(int id) {
		// TODO Auto-generated method stub
		Comments comments =commentsRepository.findById(id).get();
		return comments;
	}

}

