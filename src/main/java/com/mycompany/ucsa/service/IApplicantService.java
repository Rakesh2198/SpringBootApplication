package com.mycompany.ucsa.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.mycompany.ucsa.dto.ApplicantOrderResponse;
import com.mycompany.ucsa.entities.AdmissionStatus;
import com.mycompany.ucsa.entities.Applicant;
import com.mycompany.ucsa.exception.ApplicantNotFoundException;

@Service
public interface IApplicantService {
	
	public Applicant addApplicant(Applicant applicant);
	
	public Applicant updateApplicant(Applicant applicant);
		
	public Applicant deleteApplicant(int applicantId) throws ApplicantNotFoundException;
	
	public Applicant viewApplicant(int applicantId) throws ApplicantNotFoundException;

	public List<ApplicantOrderResponse> viewAllApplicantsByStatus(AdmissionStatus admissionStatus);
	
	public List<Applicant> fetchAll();
}