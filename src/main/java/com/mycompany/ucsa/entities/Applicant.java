package com.mycompany.ucsa.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "applicant_tbl")
public class Applicant {

	@Id
	private int applicantId;
	
	@NotNull
	@Size(min=6, message="Applicant Name should be minimum 6 characters.")
	private String applicantName;
	
	@NotNull
	@Size(min=10, message="Mobile Number should be 10 digits.")
	private String mobileNumber;
	
	@NotNull
	@Size(min=2, message="Applicant Degree should be minimum 2 characters.")
	private String applicantDegree;
	
	@OneToMany(targetEntity = Admission.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "app_adm_fk", referencedColumnName = "applicantId")
	private List<Admission> admission;
	
//	@OneToMany(targetEntity = Exam.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "app_exm_class", referencedColumnName = "applicantId")
//	private List<Exam> exam;
	

}