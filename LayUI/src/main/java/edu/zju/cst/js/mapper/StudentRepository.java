package edu.zju.cst.js.mapper;

import edu.zju.cst.js.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findAllByOrderByIdAsc();
	List<Student> findAllByOrderByIdDesc();
	List<Student> findAllByOrderByLastNameAsc();
	List<Student> findAllByOrderByLastNameDesc();
	List<Student> findAllByOrderByFirstNameAsc();
	List<Student> findAllByOrderByFirstNameDesc();
	
	Student findById(long id);
	void deleteById(long id);

	List<Student> findAllByOrderBySeqAsc();
	List<Student> findAllByOrderBySeqDesc();

	Student getById(long id);

}
