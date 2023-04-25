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
public class Contact {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	Long id;
	
	@NotNull(message = "Name may not be null")
	@Size(min = 3, max = 50 ,message = "Enter valid Name" )
	String name;
	
	
	@NotNull
	@Size(min = 1, max = 50 ,message = "Enter Valid Email")
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$",message = "Name may not be null")
	String email;
	
	@NotNull
	@Size(min = 10, max = 10,message = "Enter Valid Number")
	String num;
	
	@NotNull
	@Size(min = 1, max = 100 ,message = "Enter valid Message")
	String message;
	
	
	
	

}
