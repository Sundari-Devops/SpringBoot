package com.altimetrik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.model.Student;
import com.altimetrik.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//@RequestMapping(value = "/saveStudent",method = RequestMethod.POST)
	@PostMapping("/saveStudent")
	
public Object insertStudent(@RequestBody Student student)
{
	
	return(studentService.saveStudent(student)); 
}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents()
	{
		return(studentService.getAllStudent()); 
	}
	
	@GetMapping("/getStudentById/{id}")
	public Student getStudentById(@PathVariable int id) {
		return(studentService.getStudentById(id)) ;
	}
	
	@PutMapping("/updateStudent")
	public Object updateStudent(@RequestBody Student student) {
		return(studentService.updateStudent(student)); 
	}
//fetch students by collegeName
	@PostMapping("/getAllStudentByCollegeName")
	public List<Student> getAllStudentByCollegeName(@RequestBody Student student){
		return(studentService.getAllStudentByCollegeName(student)); 
	}
	
	//delete student by Id
	
	@GetMapping("/deleteStudById/{id}")
	public Object deleteStudent(@PathVariable int id)
	{
		return(studentService.deleteStudent(id)); 
	}
	
	@GetMapping("/getName")
	public Object getName() {
		return(studentService.getName()); 
	}

}
