package com.altimetrik.service;

import java.util.List;

import com.altimetrik.model.Student;

public interface StudentService {
	

	public Object saveStudent(Student student);
	public List<Student> getAllStudent();
	public Student getStudentById(int id);
	public Object updateStudent(Student student);
	public List<Student> getAllStudentByCollegeName(Student student);
	public Object deleteStudent(int id);
	public Object getName();
}
