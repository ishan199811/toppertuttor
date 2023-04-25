package com.toppertutors.entity;

import javax.persistence.Column;
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
public class ApplyTuttor {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	Long id;
	
	@NotNull
	@Size(min = 1, max = 50,message = "Enter Valid Name")
	String fullName;
	
	@NotNull
	@Size(min = 10, max = 10, message = "Enter Valid Number")
	String contactNum;
	
	@NotNull
	@Size(min = 3, max = 50 ,message = "Enter Valid Number")
	String qualification;

	@NotNull
	@Size(min = 3, max = 50 ,message = "Enter Valid Number")
	String address;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$",message = "Enter Valid email")
	String emialId;
	
	@NotNull
	@Size(min = 1, max = 50,message = "Enter Valid Message")
	String message;
	
	@NotNull(message = "Please Select Gender")
	String gender;

String experience;

String vehical;

@Column(nullable = true, length = 64)
private String image;

}
