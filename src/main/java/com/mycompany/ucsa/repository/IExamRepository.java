package com.mycompany.ucsa.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.ucsa.entities.Exam;
public interface IExamRepository extends JpaRepository<Exam, Integer> {
	
}