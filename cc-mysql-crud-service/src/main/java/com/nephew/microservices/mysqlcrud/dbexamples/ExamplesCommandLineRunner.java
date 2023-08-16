package com.nephew.microservices.mysqlcrud.dbexamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExamplesCommandLineRunner {

	@Autowired
	private CourseJdbcRepository jdbc;
	@Autowired
	private CourseJpaRepsitory jpa;
	@Autowired
	private CourseSpringDataJpaRepository springDataJpa;

	// @Bean
	public CommandLineRunner commandLineRunnerDbExamples() {
		return args -> {
			courseJdbcExample(jdbc);
			courseJpaExample(jpa);
			courseSpringDataJpaExample(springDataJpa);
		};
	}

	public void courseJdbcExample(CourseJdbcRepository repo) {
		repo.delete();
		repo.insert(new Course(1L, "Learn AWS", "Ethan"));
		repo.insert(new Course(2L, "Learn AW", "Ethan"));
		repo.insert(new Course(3L, "Learn AWS", "Ethan"));
		repo.delete(2L);
		System.out.println("CourseJdbcRepository: " + repo.selectById(3L));
	}

	public void courseJpaExample(CourseJpaRepsitory repo) {
		repo.delete();
		repo.insert(new Course(1L, "Learn AWS", "Ethan"));
		repo.insert(new Course(2L, "Learn AW", "Ethan"));
		repo.insert(new Course(3L, "Learn AWS", "Ethan"));
		repo.delete(2L);
		System.out.println("CourseJpaRepsitory: " + repo.selectById(3L));
	}

	public void courseSpringDataJpaExample(CourseSpringDataJpaRepository repo) {
		repo.deleteAll();
		repo.save(new Course(1L, "Learn AWS", "Ethan"));
		repo.save(new Course(2L, "Learn AW", "Ethan"));
		repo.save(new Course(3L, "Learn AWS", "Ethan"));
		repo.deleteById(2L);
		System.out.println("CourseSpringDataJpaRepository: " + repo.findById(3L));
	}

}
