package com.coforge.controllers;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
import com.coforge.entities.Student;
//import com.coforge.services.StudentService;
import com.coforge.services.StudentServices;
 
@Controller
@ResponseBody
public class StudentController {
	@Autowired
	StudentServices service;
	
	@RequestMapping("/student/list")
  public ModelAndView getAll(){
	  List<Student>slist=service.getAll();
	  ModelAndView mv=new ModelAndView("list");
	  mv.addObject("slist",slist);
	  return mv;
  }
	
	@RequestMapping("/student/add")
	public ModelAndView addStudent() {
		return new ModelAndView("add");
	}
	
	@RequestMapping("/student/delete")
	public ModelAndView delete(@RequestParam(name = "sid", required = false) Long sid) {

	    ModelAndView mv = new ModelAndView("delete");
	    boolean s= false;
	    if (sid != null) {
	        s = service.deleteStudent(sid);
	      //  mv.addObject("student", s);
	    }

	 //   boolean deleted = service.deleteStudent(sid); // returns true/false

	    if (s) {
	        mv.addObject("msg", "Student deleted successfully!");
	    } else {
	        mv.addObject("msg", "Student not found!");
	    }

	    return mv;
	}
	
	@RequestMapping(value="/student",method=RequestMethod.POST)
	public String save(@ModelAttribute Student student) {
		String s=service.save(student);
		return s;
	}


@RequestMapping("/student/get")
public ModelAndView getById(@RequestParam(name = "sid", required = false) Long sid) {

    ModelAndView mv = new ModelAndView("get");

    if (sid != null) {
        Student s = service.getById(sid);
        mv.addObject("student", s);
    }

    return mv;

}

}
 
