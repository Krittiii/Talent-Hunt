package com.code.talent.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.code.talent.models.Users;

public interface IUsersRepository extends JpaRepository<Users, Integer> {
	
	public	Users findByEmailid(String emailid);
	
}
