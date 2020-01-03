package com.pb.TestScripts.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findAllByOrderByIdAsc();
	List<Student> findAllByOrderByIdDesc();
	List<Student> findAllByOrderByLastNameAsc();
	List<Student> findAllByOrderByLastNameDesc();
	List<Student> findAllByOrderByFirstNameAsc();
	List<Student> findAllByOrderByFirstNameDesc();
	
	Student findById(long id);
	void deleteById(long id);
}
