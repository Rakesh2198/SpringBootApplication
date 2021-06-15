package com.mycompany.ucsa.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.ucsa.entities.AdmissionCommiteeMember;
import com.mycompany.ucsa.exception.CommiteeMemberNotFoundException;
import com.mycompany.ucsa.service.IAdmissionCommiteeMemberService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admisssioncommiteemember")

public class AdmissionCommiteeMemberController {
Logger logger= LoggerFactory.getLogger(AdmissionCommiteeMemberController.class);

@Autowired
private IAdmissionCommiteeMemberService service;
// add a commitee member//
@PostMapping("/save")
public ResponseEntity<AdmissionCommiteeMember> save(@Valid @RequestBody AdmissionCommiteeMember admissioncommiteemember) {
AdmissionCommiteeMember doc = service.addCommiteeMember(admissioncommiteemember);
return new ResponseEntity<>(doc, HttpStatus.CREATED);
}
//update//
@PutMapping("/update")
public ResponseEntity<AdmissionCommiteeMember> update(@Valid @RequestBody AdmissionCommiteeMember admissioncommiteemember) {
AdmissionCommiteeMember doc = service.addCommiteeMember(admissioncommiteemember);
return new ResponseEntity<>(doc, HttpStatus.CREATED);
}

@DeleteMapping("/delete/{id}")
public void delete(@PathVariable Integer id) throws NumberFormatException, CommiteeMemberNotFoundException {
	service.removeCommiteeMember(Integer.valueOf(id));
}

@GetMapping("/getById{id}")
@ApiOperation("Get Member By Id")
public AdmissionCommiteeMember FetchById(@PathVariable Integer id) throws NumberFormatException, CommiteeMemberNotFoundException {
	return service.viewCommiteeMember(Integer.valueOf(id));

}

@GetMapping("/getAll")
@ApiOperation("Fetch all AdmissionCommiteeMember Details")
public List<AdmissionCommiteeMember> fetch() {
logger.info("Fetching all AdmissionCommiteeMember records!!");
return service.viewAllCommiteeMembers();
}
}