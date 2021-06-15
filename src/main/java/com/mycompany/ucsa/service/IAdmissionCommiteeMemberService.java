package com.mycompany.ucsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycompany.ucsa.entities.AdmissionCommiteeMember;
import com.mycompany.ucsa.exception.CommiteeMemberNotFoundException;


@Service
public interface IAdmissionCommiteeMemberService {

	public  AdmissionCommiteeMember addCommiteeMember(AdmissionCommiteeMember member);

	public AdmissionCommiteeMember updateCommiteeMember(AdmissionCommiteeMember member);
 
	public AdmissionCommiteeMember viewCommiteeMember(int adminId)throws CommiteeMemberNotFoundException;
 
	public void removeCommiteeMember(int adminId) throws CommiteeMemberNotFoundException;

	public List<AdmissionCommiteeMember> viewAllCommiteeMembers();

	//public void provideAdmissionResult(Applicant applicant, Admission admission);
}