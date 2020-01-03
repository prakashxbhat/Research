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
		studentModel.addAttribute("students", studentRepository.findAll());
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

}
