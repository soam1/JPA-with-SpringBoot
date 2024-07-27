package com.akashsoam.bootJpaExample.dao;


import org.springframework.data.repository.query.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akashsoam.bootJpaExample.entities.User;

import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{
	//iske andar hme asliyat m spring hota to CRUD methods likhne pdte, BUT Springboot sare CRUD methods ki implementation dega khud, just extends (upr vali) line se
	public List<User> findByName(String name);
	
	//JQL or JPQL (Java Persistence Query Language) similar to HQL (Hibernate Query Language)
	@Query("select u from User u")
	public List<User> getAllUsers();
	
	//parameterised query
	@Query("select u from User u where u.name = :n")
	public List<User> getUserByName(@Param("n")String n);
	
	//native Query 
	@Query(value = "select * from user", nativeQuery = true)
	public List<User> getAllUsersNative();

}
