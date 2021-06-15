package com.mycompany.ucsa.entities;

import java.util.Date;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Couseid;
	
	@Column(name = "coursename")
	@NotNull	
	private String CourseName;
	
	@Column(name = "courseduration")
	@NotNull
	private String CourseDuration;
	
	@Column(name = "coursestartdate")
	@NotNull
	private Date CourseStartDate;
	
	@Column(name = "courseenddate")
	private Date CourseEndDate;
	
	@Column(name = "coursefee")
	private String CourseFee;
	
	@OneToMany(targetEntity = Faculty.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cf_fk", referencedColumnName = "Couseid")
	private List<Faculty> faculty;
	

}
	


