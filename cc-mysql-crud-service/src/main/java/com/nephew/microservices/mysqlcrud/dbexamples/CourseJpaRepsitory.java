package com.nephew.microservices.mysqlcrud.dbexamples;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepsitory {

	@PersistenceContext
	private EntityManager entityManager;

	public void insert(Course course) {
		entityManager.merge(course);
	}

	public Course selectById(Long id) {
		return entityManager.find(Course.class, id);
	}

	public void delete(Long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}

	public void delete() {
		List<Course> courses = entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
		for(Course course: courses) {
			entityManager.remove(course);
		}
	}

}
