package com.code.talent.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.code.talent.models.Talent;
import com.code.talent.repositories.ITalentRepository;

@Service
public class TalentService implements ITalentService {
@Autowired
ITalentRepository talentRepository;
	@Override
	public Talent add(Talent talent) {
		// TODO Auto-generated method stub
		return talentRepository.save(talent);
	}

	@Override
	public Talent update(Talent talent) {
		// TODO Auto-generated method stub
		return talentRepository.save(talent);
	}

	@Override
	public String delete(Talent talent) {
		// TODO Auto-generated method stub
		talentRepository.delete(talent);
		return "Record is deletd";
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		Talent talent=talentRepository.findById(id).get();
		if(talent==null)
		{
			return "Talent  with Id "+id+" not found";
		}
		talentRepository.delete(talent);
		return "Record is deletd";
	}

	@Override
	public List<Talent> getAll() {
		// TODO Auto-generated method stub
		return talentRepository.findAll();
	}

	@Override
	public Talent getById(int id) {
		// TODO Auto-generated method stub
		Talent talent= talentRepository.findById(id).get();
		return talent;
	}

}
