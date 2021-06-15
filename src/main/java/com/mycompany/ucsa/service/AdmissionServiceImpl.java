package com.mycompany.ucsa.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ucsa.dto.OrderResponse1;
import com.mycompany.ucsa.entities.Admission;
import com.mycompany.ucsa.exception.AdmissionNotGrantedException;
import com.mycompany.ucsa.exception.ApplicantNotFoundException;
import com.mycompany.ucsa.repository.IAdmissionRepository;

@Service
public class AdmissionServiceImpl implements IAdmissionService {

	@Autowired
	private IAdmissionRepository admissionRepository;

	@Override
	public Admission addAdmission(Admission admission) {

		return admissionRepository.save(admission);
	}

	@Override
	public Admission updateAdmission(Admission admission) {

		return admissionRepository.save(admission);
	}

	@Override
	public void cancelAdmission(int admissionId) throws AdmissionNotGrantedException {
		
		Optional<Admission> admission = admissionRepository.findById(admissionId);
		if (!admission.isPresent())
			throw new AdmissionNotGrantedException();
		admissionRepository.deleteById(admissionId);

	}

	@Override
	public List<OrderResponse1> showAllAdmissionsByCourse(int admissionId) {

		return admissionRepository.showAllAdmissionsByCourse(admissionId);
	}

	@Override
	public List<OrderResponse1> showAllAdmissionsByDate(java.util.Date date) {
		
		return admissionRepository.showAllAdmissionsByDate(date);
	}

	@Override
	public List<Admission> fetchAll() {

		return admissionRepository.findAll();
	}

	@Override
	public List<OrderResponse1> showAllAdmissionsByApplicant(int applicantId) throws ApplicantNotFoundException{
		
		Optional<Admission> admission = admissionRepository.findById(applicantId);
		if (!admission.isPresent())
			throw new ApplicantNotFoundException();
		return admissionRepository.showAllAdmissionsByApplicant(applicantId);
		
	}

//	@Override
//	public double calculateTotalCost(int courseId) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}