package com.toppertutors.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.Data;

@Entity
@Data
public class User {

	



	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	
	
	private String  lastName;
	
	

	@NotNull
	@Size(min = 1, max = 100)
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$")
	private String email;
	
	
	private String password;
	
	@Transient
	private String confirmPassword;
	
	  private boolean enabled;
	    private boolean tokenExpired;

	    
	    @ManyToMany
	    private Set<Role> roles;
	    
	    
}
