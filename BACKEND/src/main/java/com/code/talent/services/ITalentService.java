package com.code.talent.services;

import java.util.List;

import com.code.talent.models.Talent;

public interface ITalentService {
	public Talent add(Talent talent);
	public Talent update(Talent talent);
	public String delete(Talent talent);
	public String delete(int id);
	
	//create some method to get the participant by id
	
	public List<Talent> getAll();
	public Talent getById(int id);
}
