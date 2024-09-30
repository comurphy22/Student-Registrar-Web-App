package com.citizens.ProjectTwo.RegistrarSpring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity	
@Table
public class Student {
	@Id
	@SequenceGenerator(
			name="student_sequence",
			sequenceName="student_sequence",
			allocationSize=1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, generator ="student_sequence")
	private int id;
	
	private String name;

	
	
	public Student()
	{
		
	}

	public Student(int id, String name) {
		this.id=id;
		this.name=name;
	}

	public Student(String name) {
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	




}
