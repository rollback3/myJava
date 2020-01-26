package com.cg.secureapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User_Details, Long> {
	
	User_Details findByUsername(String username);

}
