package com.toppertutors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toppertutors.entity.ApplyTuttor;
import com.toppertutors.entity.HireTuttor;

public interface ApplyTuttorRepository extends JpaRepository<ApplyTuttor , Long>{

	List<ApplyTuttor> findAll();

}
