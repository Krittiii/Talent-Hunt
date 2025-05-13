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

import com.code.talent.models.Talent;
import com.code.talent.services.ITalentService;

@RestController
@RequestMapping("api/talent/")
public class TalentController {
	@Autowired
	ITalentService talentService;
	
	@GetMapping(value = "/")
	public List<Talent> getAllTalent() {
		return talentService.getAll();
	}
	
	@GetMapping(value="/{id}")
	public Talent getTalentById(@PathVariable("id") int id) {
		return talentService.getById(id);
	}
	@PostMapping(value="create")
	public Talent createTalent(@RequestBody Talent talent) {
		return talentService.add(talent);
	}
	@PutMapping(value="edit")
	public Talent editTalent(@RequestBody Talent talent) {
		return talentService.update(talent);
	}
	@DeleteMapping(value="delete/{id}")
	public String deleteTalent(@PathVariable("id") int id) {
		return talentService.delete(id);
	}
	
}
