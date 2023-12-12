package com.sagar.spring_boot.jpa_hibernate.course.jdbc.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sagar.spring_boot.jpa_hibernate.course.Course;
import com.sagar.spring_boot.jpa_hibernate.course.jpa.CourseJpaRepository;
import com.sagar.spring_boot.jpa_hibernate.course.springDataJPA.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	/*
	@Override
	public void run(String... args) throws Exception{
		repository.insert(new Course(1,"AWS1","SAGAR"));
		repository.insert(new Course(2,"AWS2","SAGAR"));
		repository.insert(new Course(3,"AWS7","SAGAR"));
		repository.insert(new Course(4,"AWS6","SAGAR"));
		
		repository.deleteById(2);
		
		System.out.println(repository.findById(3));
	}
	*/
	
	@Override
	public void run(String... args) throws Exception{
		repository.save(new Course(1,"AWS1","SAGAR"));
		repository.save(new Course(2,"AWS2","SUNAR"));
		repository.save(new Course(3,"AWS7","SAMBHAV"));
		repository.save(new Course(4,"AWS6","SUBAS"));
		
		repository.deleteById(2l);
		
		System.out.println(repository.findById(3l));
		System.out.println(repository.findById(4l));
		
		System.out.println(repository.count());
		System.out.println(repository.findAll());
		System.out.println(repository.findByAuthor("SUBAS"));
	}

}
