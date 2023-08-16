package com.nephew.microservices.mysqlcrud.dbexamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate; // 

	private final String INSERT_QUERY = "insert into course (id, name, author) values(1, 'Learn AWS', 'in28minutes');";
	private String INSERT_DATA_QUERY =  "insert into course (id, name, author) values(?, ?, ?);";
	private final String DELETE_ALL = "DELETE FROM course;";
	private String DELETE_BY_ID = "DELETE FROM course WHERE id=?";
	private String SELECT_BY_ID = "SELECT * FROM course WHERE id=?";

	
	public void insert() {
		// springJdbcTemplate.update(INSERT_QUERY);
	};
	
	public void delete() {
		springJdbcTemplate.update(DELETE_ALL);
	}
	
	public void delete(Long id) {
		springJdbcTemplate.update(DELETE_BY_ID, id);
	}
	
	public Course selectById(Long id) {
		Course course = springJdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(Course.class), id);
		return course;
	}
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_DATA_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
}
