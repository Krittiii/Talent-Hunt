package com.code.talent.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.code.talent.models.Comments;


public interface ICommentsRepository extends JpaRepository<Comments, Integer>{

}
