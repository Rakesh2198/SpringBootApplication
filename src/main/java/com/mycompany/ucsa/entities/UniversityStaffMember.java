package com.mycompany.ucsa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@NoArgsConstructor


@Entity
@Table
public class UniversityStaffMember {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int staffId;
	@NotNull
	@Size(max = 8,min = 4 ,message = ("Password should have max 8 and min 4characters"))
	private String password;
	@NotNull
	private String role;
	
	
}