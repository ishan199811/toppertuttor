package com.toppertutors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.toppertutors.entity.Contact;


public interface ContactRepository extends JpaRepository<Contact,Long> {
	List<Contact> findAll();
}
