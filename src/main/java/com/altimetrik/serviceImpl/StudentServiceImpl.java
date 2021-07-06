package com.altimetrik.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.altimetrik.model.Student;
import com.altimetrik.repository.StudentRepo;
import com.altimetrik.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepo studRepo;

	@Override
	@Transactional
	public Object saveStudent(Student student) {
		// TODO Auto-generated method stub
		Map<String ,String> map = new HashMap<>();
		if(student.getName().isEmpty()) {
			map.put("Status", "error");
			map.put("msg", "Please enter the name");
			
		}else {
			map.put("Status","200");
			map.put("msg","Success");
			studRepo.save(student);	
		}
		
		//studRepo.save(student);
		return map;
	}

	@Override
	@Transactional
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studRepo.findAll();
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		
		return studRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Object updateStudent(Student student) {
		Map<String ,String> map = new HashMap<>();
		if(student.getName().isEmpty()) {
			map.put("Status", "error");
			map.put("msg", "Please enter the name");
			
		}else {
			map.put("Status","200");
			map.put("msg","Date Updated Successfully");
			studRepo.saveAndFlush(student);
		}
		return map;
	}

	@Override
	@Transactional
	public List<Student> getAllStudentByCollegeName(Student student) {
		// TODO Auto-generated method stub
		return studRepo.getAllStudentByCollegeName(student.getCollegeName());
	}

	@Override
	@Transactional
	public Object deleteStudent(int id) {
		Map<String ,String> map = new HashMap<>();
		/*if(id == Stu) {
			map.put("Status", "error");
			map.put("msg", "Please enter the id");
			
		}else {*/
			map.put("Status","200");
			map.put("msg","Student details deleted Successfully");
			studRepo.deleteById(id);
		//}
		return map;
	}

	@Override
	@Transactional
	public Object getName() {
		// TODO Auto-generated method stub
		Map<String ,String> map = new HashMap<>();
		map.put("name", "AnuRadha");
		
		return map;
	}

}
