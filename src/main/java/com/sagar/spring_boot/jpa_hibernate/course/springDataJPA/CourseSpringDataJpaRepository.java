package com.sagar.spring_boot.jpa_hibernate.course.springDataJPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.spring_boot.jpa_hibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

	List<Course> findByAuthor(String author);
}
