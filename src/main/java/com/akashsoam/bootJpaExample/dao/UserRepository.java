package com.akashsoam.bootJpaExample.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akashsoam.bootJpaExample.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	//iske andar hme asliyat m spring hota to CRUD methods likhne pdte, BUT Springboot sare CRUD methods ki implementation dega khud, just extends (upr vali) line se

}
