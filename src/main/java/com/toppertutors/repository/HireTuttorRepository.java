package com.toppertutors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toppertutors.entity.HireTuttor;

public interface HireTuttorRepository extends JpaRepository<HireTuttor , Long>{

	List<HireTuttor> findAll();

}
