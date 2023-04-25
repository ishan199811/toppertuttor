package com.toppertutors.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Teachers {
	
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	
	private String address;
	
	private String phoneNo;
	
	private String subject;
	
	private String area;
	
	private String otherActivity;

	private String experience;
	
	private String  qualification;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="teachers")
	
    private List<Students> student=new ArrayList();
	

}
