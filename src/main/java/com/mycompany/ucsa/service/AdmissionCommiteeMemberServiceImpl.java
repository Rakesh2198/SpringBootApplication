package com.mycompany.ucsa.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ucsa.entities.AdmissionCommiteeMember;
import com.mycompany.ucsa.exception.CommiteeMemberNotFoundException;
import com.mycompany.ucsa.repository.IAdmissionCommiteeMemberRepository;

@Service
public class AdmissionCommiteeMemberServiceImpl implements IAdmissionCommiteeMemberService {

	Logger logger = LoggerFactory.getLogger(AdmissionCommiteeMemberServiceImpl.class);

	@Autowired
	private IAdmissionCommiteeMemberRepository repository;

	@Override
	public AdmissionCommiteeMember addCommiteeMember(AdmissionCommiteeMember member) {
		logger.info("add commitee member");
		return repository.save(member);

	}

	@Override
	public AdmissionCommiteeMember updateCommiteeMember(AdmissionCommiteeMember member) {
		return repository.save(member);
	}

	@Override
	public AdmissionCommiteeMember viewCommiteeMember(int adminId) throws CommiteeMemberNotFoundException {
		Optional<AdmissionCommiteeMember> member = repository.findById(adminId);
		if (!member.isPresent())
			throw new CommiteeMemberNotFoundException();
		return member.get();

	}

	@Override
	public void removeCommiteeMember(int adminId) throws CommiteeMemberNotFoundException {
		Optional<AdmissionCommiteeMember> member = repository.findById(adminId);
		if (!member.isPresent())
			throw new CommiteeMemberNotFoundException();
		repository.deleteById(adminId);
	}

	
	
	@Override
	public List<AdmissionCommiteeMember> viewAllCommiteeMembers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

//@Override
//public void provideAdmissionResult(Applicant applicant, Admission admission) {
	// TODO Auto-generated method stub

}