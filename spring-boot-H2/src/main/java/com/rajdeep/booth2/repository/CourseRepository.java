package com.rajdeep.booth2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajdeep.booth2.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
