package com.rajdeep.booth2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajdeep.booth2.ResourceNotFoundException;
import com.rajdeep.booth2.entity.Course;
import com.rajdeep.booth2.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	public List<Course> getCourses() {
		return courseRepository.findAll();
	}

	public Course getCourseById(int id) {
		return courseRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee not found" + id));
	}
	
}
