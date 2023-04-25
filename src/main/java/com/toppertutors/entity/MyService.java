package com.toppertutors.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MyService {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String services;
	private String description;
	private String image;
	
	
	

}
