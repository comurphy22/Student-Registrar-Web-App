package com.citizens.ProjectTwo.RegistrarSpring.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.citizens.ProjectTwo.RegistrarSpring.Repository.StudentRepository;
import com.citizens.ProjectTwo.RegistrarSpring.models.Student;

import jakarta.transaction.Transactional;


@Service
public class StudentService {
	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository)
	{
		this.studentRepository=studentRepository;
	}
	
	public List<Student> getStudents(){
		return studentRepository.findAll();
				
				
	}
	

	public void addNewStudent(Student student) {
		Optional<Student>studentByName=studentRepository.findStudentByName(student.getName()); 
		if(studentByName.isPresent())
		{
			throw new IllegalStateException("Name already exists");
		}
		studentRepository.save(student);
		
	}

	public void deleteStudent(int id) {
		boolean exists=studentRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("student with id" + id +"does not exists");
		}
		studentRepository.deleteById(id);
	}
	
	@Transactional
	public void updateStudent(int studentId, String name) {
		Student student=studentRepository.findById(studentId)
				.orElseThrow(()-> new IllegalStateException( " student with id" + studentId + "does not exist"));
		
				if(name!=null
						&& name.length()> 0
						&& !Objects.equals(student.getName(),name ))
				{
					student.setName(name);
				}
		
		
		
		 
		
	}
	

	
}
