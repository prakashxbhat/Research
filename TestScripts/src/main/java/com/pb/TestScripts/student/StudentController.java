package com.pb.TestScripts.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;

	// Generate URL of table.html
	@GetMapping(value = { "/table" }) // URL path
	public String table(Model studentModel) {
		//studentModel.addAttribute("students", studentRepository.findAll());
		studentModel.addAttribute("students", studentRepository.findAllByOrderBySeqAsc());

		return "table"; // HTML page
	}

	// Add/Update entity
	@PostMapping(value = "/save")
	public String save(Student student, Model model) {
		studentRepository.save(student);
		return "redirect:/table"; // HTML page
	}

	// Delete entity
	@GetMapping(value = "/delete")
	public String delete(long id) {
		studentRepository.deleteById(id);
		return "redirect:/table"; // HTML page
	}

	// Find entity of EME
	@GetMapping(value = "/find")
	public @ResponseBody Student findStudentById(long id) {
		return studentRepository.findById(id);
	}

	@PostMapping(value = "/changeOrder")
	public @ResponseBody String changeSeq(long id1, long id2){
		//no matter move up or move down, the parameter id1 is always the id of the nearest row above id2.
		// according to coding convention, the process logic should be placed at Service layer,
		// since this demo hasn't Service layer, I write those code here.

		// query Student corresponding to id1 and id2, and check there order to ensure that
		// id1's order is smaller than id2's.
		Student stu1 = studentRepository.getById(id1);
		Student stu2 = studentRepository.getById(id2);
		if(stu1 == stu2){
			//deal the situation that we click the original top row.
			return "no need exchange";
		}else{
			int tmp = stu1.getSeq();
			stu1.setSeq(stu2.getSeq());
			stu2.setSeq(tmp);
			studentRepository.save(stu1);
			studentRepository.save(stu2);

		}


		return "success";
	}

}
