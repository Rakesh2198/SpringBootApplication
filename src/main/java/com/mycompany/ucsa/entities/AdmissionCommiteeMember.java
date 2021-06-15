package com.mycompany.ucsa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="admission_commitee_member")
public class AdmissionCommiteeMember {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	
	@Column(name= "adminName")
	@NotNull
	private String adminName;
	
	@Column(name= "adminContact")
	@NotNull
	private String adminContact;
	
}