package com.altimetrik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.altimetrik.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

	//JPQL-Java persetent Query Language
	@Query("select u from Student u where u.collegeName=:collegeName")
	List<Student> getAllStudentByCollegeName(@Param("collegeName") String collegeName);

}
