package com.mycompany.ucsa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Exam_Details")
public class Exam { 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ExamId;
	@Column(name = "sscMarks")
	@NotNull
	@Min(value = 60, message = "Minimum of 60% marks required in SSC Examination")
	private double sscMarks; 
	@Column(name = "hscMarks")
	@NotNull
	@Min(value = 60, message = "Minimum of 60% marks required in HSC Examination")
	private double hscMarks;
	@Column(name = "cetMarks")
	@NotNull
	@Min(value = 100, message = "Minimum 100 marks are required in CET")
	private int cetMarks;
}