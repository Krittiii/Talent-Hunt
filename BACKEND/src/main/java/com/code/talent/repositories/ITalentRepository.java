package com.code.talent.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.code.talent.models.Talent;


public interface ITalentRepository extends JpaRepository<Talent, Integer> {

}
