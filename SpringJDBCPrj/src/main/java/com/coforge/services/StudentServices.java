package com.coforge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coforge.dao.StudentDao;
import com.coforge.entities.Student;


@Service
public class StudentServices implements StudentServiceInterface {
    
	@Autowired
	private StudentDao dao;
	
	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
				return dao.getAll();
	}



	@Override
	public String save(Student student) {
		// TODO Auto-generated method stub
		return dao.save(student);
	}

	@Override
	public Student getById(long sid) {
		// TODO Auto-generated method stub
		return dao.getById(sid);
	}

	
}
