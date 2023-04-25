package com.toppertutors.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.toppertutors.entity.User;

public interface UserRepository extends JpaRepository<User , Long>{

User findByEmail(String email);



}
