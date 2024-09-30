package com.citizens.ProjectTwo.RegistrarSpring.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citizens.ProjectTwo.RegistrarSpring.models.Student;

//@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
//Take note that this is not SQL and Student here refers to the domain object and NOT the table   
	@Query("SELECT s FROM Student s where s.name=?1")
Optional<Student> findStudentByName(String name);
}
 