package com.toppertutors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toppertutors.entity.MyService;
@Repository
public interface ServiceRepository extends JpaRepository<MyService,Long>{
	List<MyService> findAll();
}
