package com.mycompany.ucsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycompany.ucsa.dto.OrderResponse1;
import com.mycompany.ucsa.entities.Admission;
import com.mycompany.ucsa.exception.AdmissionNotGrantedException;
import com.mycompany.ucsa.exception.ApplicantNotFoundException;

@Service
public interface IAdmissionService {
	
	public Admission addAdmission(Admission admission);

	public Admission updateAdmission(Admission admission);
	
	public void cancelAdmission(int admissionId) throws AdmissionNotGrantedException;
	
	public List<OrderResponse1> showAllAdmissionsByCourse(int admissionId);
	
	public List<OrderResponse1> showAllAdmissionsByDate(java.util.Date date);
	
	public List<OrderResponse1> showAllAdmissionsByApplicant(int applicantId) throws ApplicantNotFoundException;
	
	//public double calculateTotalCost(int courseId);

	public List<Admission> fetchAll();
	
}