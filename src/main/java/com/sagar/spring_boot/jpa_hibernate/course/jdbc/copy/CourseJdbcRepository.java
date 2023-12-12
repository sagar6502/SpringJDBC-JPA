package com.sagar.spring_boot.jpa_hibernate.course.jdbc.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagar.spring_boot.jpa_hibernate.course.Course;

@Repository //Class connects with DB
public class CourseJdbcRepository {
	
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private  static String  INSERT_QUERY = 
			"""
				INSERT INTO COURSE(ID, NAME, AUTHOR)
				VALUES(?, ?, ?);
			""";
	
	private  static String  DELETE_QUERY = 
			"""
				DELETE FROM COURSE WHERE ID = ?;
			""";
	
	private  static String  SELECT_QUERY = 
			"""
				SELECT * FROM COURSE WHERE ID = ?;
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	public Course selectById(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY,
				new BeanPropertyRowMapper<>(Course.class), id);
		//ResultSet -> Bean == row mapper
		//
	}
}
