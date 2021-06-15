package com.mycompany.ucsa.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.ucsa.dto.ApplicantOrderResponse;
import com.mycompany.ucsa.entities.AdmissionStatus;
import com.mycompany.ucsa.entities.Applicant;

@Repository
public interface IApplicantRepository extends JpaRepository<Applicant, Integer>{

	@Query("SELECT new com.mycompany.ucsa.dto.ApplicantOrderResponse(apl.applicantId, apl.applicantName, apl.mobileNumber, apl.applicantDegree, adm.admissionStatus) FROM Applicant apl JOIN apl.admission adm WHERE adm.admissionStatus=:admissionStatus")
	public List<ApplicantOrderResponse> viewAllApplicantByAdmissionStatus(@Param("admissionStatus")AdmissionStatus admissionStatus);

}