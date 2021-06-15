package com.mycompany.ucsa.dto;

import com.mycompany.ucsa.entities.AdmissionStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantOrderResponse {

	private int applicantId;
	private String applicantName;
	private String mobileNumber;
	private String applicantDegree;
	private AdmissionStatus admissionStatus;
}