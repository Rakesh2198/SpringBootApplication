package com.mycompany.ucsa.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.ucsa.entities.Exam;
import com.mycompany.ucsa.exception.MarksNotFoundException;
import com.mycompany.ucsa.repository.IExamRepository;
@Service
public class ExamServiceImpl implements IExamService{
	
	@Autowired
	private IExamRepository repository;
	
	@Override
	public Exam addMarks (Exam exam) {
		return repository.save(exam);
	}
	
	@Override
	public List<Exam> fetchAll() {
		return repository.findAll();
	}
	
	@Override
	public void updateMarks(Exam exam) {
		repository.save(exam);
	}
	
	@Override
	public void delMarks (int ExamId) throws MarksNotFoundException{
		Optional<Exam> exam = repository.findById(ExamId);
		if (!exam.isPresent())
			throw new MarksNotFoundException();
		repository.deleteById(ExamId);
	}
	
	@Override
	public Exam fetchById (int ExamId) throws MarksNotFoundException{
		Optional<Exam> exam = repository.findById(ExamId);
		if (!exam.isPresent())
			throw new MarksNotFoundException();
		return exam.get();
	}
}