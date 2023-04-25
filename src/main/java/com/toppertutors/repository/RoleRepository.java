package com.toppertutors.repository;

import java.util.HashSet;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toppertutors.entity.Role;


public interface RoleRepository extends JpaRepository<Role , Long> {


}
