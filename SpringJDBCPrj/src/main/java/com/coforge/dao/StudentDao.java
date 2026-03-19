package com.coforge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.coforge.entities.Student;

@Component
public class StudentDao implements StudentDaoInterface{
    @Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Student> getAll() {
		String query ="Select * from student";
		RowMapper<Student> rowMapper=(rs,rows)->{
	      Student s = new Student();
	      s.setSid(rs.getLong("sid"));
	      s.setSname(rs.getString("sname"));
	      s.setCourse(rs.getString("course"));
	      s.setAddress(rs.getString("address"));
	      return s;
		};
	return jdbcTemplate.query(query, rowMapper);
	//return null;
	}

	@Override
	public String save(Student student) {
		// TODO Auto-generated method stub
		String query="insert into student(sname,course,address) values(?,?,?)";
		jdbcTemplate.update(query,student.getSname(),student.getCourse(),student.getAddress());
		return "row inserted";
	}
	@Override
	public boolean deleteStudent(long sid) {
		String query="delete from student where sid=?";
		jdbcTemplate.update(query,sid);
		System.out.println("row deleted");
        return true;
	}
	public Student getById(long sid) {
		String query ="select * from student where sid=?";
		RowMapper<Student> rowMapper=(rs,rows)->{
		      Student s = new Student();
		      s.setSid(rs.getLong("sid"));
		      s.setSname(rs.getString("sname"));
		      s.setCourse(rs.getString("course"));
		      s.setAddress(rs.getString("address"));
		      return s;
			};
		return jdbcTemplate.queryForObject(query,rowMapper,sid);
	}
  
}
