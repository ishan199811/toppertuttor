package com.toppertutors.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table
public class Students {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
		private String name;
	private String address;
	
	@NotNull
	@Size(min = 10, max = 10)
	private String num;
	
	private String teacher;
	
	private String gaurdianName;
	
	private String subject;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teachers_Id")
	    private Teachers teachers;
	
}
