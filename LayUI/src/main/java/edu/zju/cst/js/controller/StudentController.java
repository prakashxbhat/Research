package edu.zju.cst.js.controller;

import edu.zju.cst.js.entity.ResponseData;
import edu.zju.cst.js.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * 类功能描述
 *
 * @Author rowe
 * @Date 2020/1/6 20:51
 */

@Controller
@RequestMapping("/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value={"/","/table"})
    public String table(){
        return "table";
    }

    @GetMapping("/userData")
    @ResponseBody
    public ResponseData data(){
        return new ResponseData(studentService.allStuByOrder());
    }

    @PostMapping(value = "/changeOrder")
    public @ResponseBody String changeSeq(Integer id1, Integer id2){
        return studentService.changeOrder(id1, id2);
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    public String delete(Integer id) {
        return studentService.delete(id);
    }

    @PostMapping("/unitChange")
    @ResponseBody
    public String update(Long id, String value, String field){
        return studentService.updateFields(id, value, field);
    }

}
