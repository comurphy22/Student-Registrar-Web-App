package com.citizens.ProjectTwo.RegistrarSpring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citizens.ProjectTwo.RegistrarSpring.Service.StudentService;
import com.citizens.ProjectTwo.RegistrarSpring.models.Student;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
	@Autowired
	private final StudentService studentService;
	public StudentController(StudentService studentService)
	{
		this.studentService=studentService;
	}
@GetMapping
public List<Student> getStudents()
{
	return studentService.getStudents();
	
	
}

@PostMapping
public void registerNewStudent(@RequestBody Student student) {
	studentService.addNewStudent(student);
}

@DeleteMapping(path="{studentId}")
public void deleteStudent(@PathVariable("studentId") int id)
{
	studentService.deleteStudent(id);
}

@PutMapping(path = {"studentId"})
public void updateStudent(
	@PathVariable("studentId") int studentId,
	@RequestParam(required=false) String name)
	{
	studentService.updateStudent(studentId, name);
}
}


