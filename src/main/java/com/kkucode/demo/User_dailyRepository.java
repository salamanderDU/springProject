package com.kkucode.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface User_dailyRepository extends JpaRepository<User_daily, Long> {
	//JpaRepository
	//@Query("SELECT u FROM u User_daily u WHERE u.username = ?1")
//	User_daily findByUsername(String username);
	
	public User_daily findByUsername(String username); 

}
