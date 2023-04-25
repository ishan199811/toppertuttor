package com.toppertutors.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class HireTuttor {
	
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@NotNull
	@Size(min = 3, max = 50,message = "Enter Valid Name")
	String studentName;
	
	String subject;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$", message = "Enter Valid Email")
	String email;
	
	String forClass;
	
	@NotNull
	@Size(min = 0, max = 50)
	String reqirements;
	
	@NotNull
	@Size(min = 3, max = 50 , message = "please fill the field cant be empty")
	String gaurdiansName;
	
	@NotNull
	@Size(min = 3, max = 50 ,message = "Enter Valid Address")
	String address;
	
	@NotNull
	@Size(min = 10, max = 10 ,message = "Enter Valid Number")
	String contactNo;

}
