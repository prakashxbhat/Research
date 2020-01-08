package edu.zju.cst.js.service;

import edu.zju.cst.js.entity.Student;
import edu.zju.cst.js.mapper.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类功能描述
 *
 * @Author rowe
 * @Date 2020/1/6 20:56
 */

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> allStuByOrder(){
        return studentRepository.findAllByOrderBySeqAsc();
    }

    public String delete(Integer id){
        studentRepository.deleteById(id);
        return "success";
    }

    public String updateFields(Long id, String value, String field){
        Student stu = studentRepository.getById(id);
        if(field.equals("firstName")){
            stu.setFirstName(value);
        }else if(field.equals("lastName")){
            stu.setLastName(value);
        }else{
            stu.setEmailAddress(value);
        }
        studentRepository.save(stu);
        return "success";
    }

    public String changeOrder(Integer id1, Integer id2){
        Student stu1 = studentRepository.getById(id1);
        Student stu2 = studentRepository.getById(id2);

        Integer tmp = stu1.getSeq();
        stu1.setSeq(stu2.getSeq());
        stu2.setSeq(tmp);
        studentRepository.save(stu1);
        studentRepository.save(stu2);

        return "success";
    }
}
