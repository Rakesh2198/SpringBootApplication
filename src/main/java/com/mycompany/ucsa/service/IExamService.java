package com.mycompany.ucsa.service;
import java.util.*;

import org.springframework.stereotype.Service;
import com.mycompany.ucsa.entities.Exam;
import com.mycompany.ucsa.exception.MarksNotFoundException;

@Service
public interface IExamService {
	Exam addMarks (Exam exam);
	
	List<Exam> fetchAll();
	
	void updateMarks(Exam exam);
	
	void delMarks (int ExamId) throws MarksNotFoundException;
	
	Exam fetchById (int ExamId) throws MarksNotFoundException;
}