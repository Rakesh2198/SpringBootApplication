package com.mycompany.ucsa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor


@Entity
@Table(name = "faculty1")
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int FacultyId;
	@NonNull
	private String Name;
	@NonNull
	private String Email;
	@NonNull
	private String Subject;
	@NonNull
	private String ContactNo; 
	
//@OneToMany(targetEntity= Course.class,cascade= CascadeType.ALL)
//@JoinColumn(name = "course_fk",referencedColumnName="FacultyId")
//List<Course> course;
	
	
	
	
}