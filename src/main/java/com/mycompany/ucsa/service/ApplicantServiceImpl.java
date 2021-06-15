package com.mycompany.ucsa.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ucsa.dto.ApplicantOrderResponse;
//import com.mycompany.ucsa.entities.Admission;
import com.mycompany.ucsa.entities.AdmissionStatus;
import com.mycompany.ucsa.entities.Applicant;
//import com.mycompany.ucsa.exception.AdmissionNotGrantedException;
import com.mycompany.ucsa.exception.ApplicantNotFoundException;
import com.mycompany.ucsa.repository.IApplicantRepository;

@Service
public class ApplicantServiceImpl implements IApplicantService {

	@Autowired
	private IApplicantRepository applicantRepository;

	@Override
	public Applicant addApplicant(Applicant applicant) {

		return applicantRepository.save(applicant);
	}

	@Override
	public Applicant updateApplicant(Applicant applicant) {

		return applicantRepository.save(applicant);
	}

	@Override
	public Applicant deleteApplicant(int applicantId) throws ApplicantNotFoundException {
		
		Optional<Applicant> applicant = applicantRepository.findById(applicantId);
		if (!applicant.isPresent())
			throw new ApplicantNotFoundException();
		applicantRepository.deleteById(applicantId);
		return applicant.get();

	}

	@Override
	public Applicant viewApplicant(int applicantId) throws ApplicantNotFoundException {
		
		Optional<Applicant> applicant = applicantRepository.findById(applicantId);
		if (!applicant.isPresent())
			throw new ApplicantNotFoundException();
		return applicant.get();
	}

	@Override
	public List<Applicant> fetchAll() {
		
		return applicantRepository.findAll();
	
	}

	@Override
	public List<ApplicantOrderResponse> viewAllApplicantsByStatus(AdmissionStatus admissionStatus) {
		
		return applicantRepository.viewAllApplicantByAdmissionStatus(admissionStatus);
	
	}

}