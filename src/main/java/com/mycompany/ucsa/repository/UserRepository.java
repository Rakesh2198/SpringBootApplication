package com.mycompany.ucsa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.ucsa.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email); 

}
