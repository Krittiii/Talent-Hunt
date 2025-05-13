
package com.code.talent.services;

import java.util.List;

import com.code.talent.models.Comments;


public interface ICommentsService {
	public Comments add(Comments comments);
	public Comments update(Comments comments);
	public String delete(Comments comments);
	public String delete(int id);
	
	//create some method to get the participant by id
	
	public List<Comments> getAll();
	public Comments getById(int id);
}
