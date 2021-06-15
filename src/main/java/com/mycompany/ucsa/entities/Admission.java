package com.mycompany.ucsa.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "admission_tbl")
public class Admission {
	
	@Id
	private int admissionId;
	private int courseId;
	private int applicantId;
	@Temporal(TemporalType.DATE)
	private java.util.Date admissionDate;
	@Enumerated(EnumType.STRING)
	private AdmissionStatus admissionStatus;
	
//	@OneToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "ac_fk", referencedColumnName = "admissionId")
//	private List<Course> course;

}