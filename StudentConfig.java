package com.citizens.ProjectTwo.RegistrarSpring.models;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.citizens.ProjectTwo.RegistrarSpring.Repository.StudentRepository;

@Configuration
public class StudentConfig {
	
	@Bean
CommandLineRunner commandLineRunner(StudentRepository repository)
{
	return args ->{
		Student jon=new Student(1,"jon");
		Student conner=new Student(2,"conner");
		Student gavin=new Student(3,"gavin");
		
		repository.saveAll(List.of(jon,conner,gavin));
				
	};
}
}
