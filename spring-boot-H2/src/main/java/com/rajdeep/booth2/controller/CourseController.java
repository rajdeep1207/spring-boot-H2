package com.rajdeep.booth2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajdeep.booth2.ResourceNotFoundException;
import com.rajdeep.booth2.entity.Course;
import com.rajdeep.booth2.model.CourseErrorResponse;
import com.rajdeep.booth2.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService CourseService;

	@PostMapping("/add")
	public Course addCourse(@RequestBody Course course) {
		return CourseService.addCourse(course);
	}

	@GetMapping("/fetch")
	public @ResponseBody List<Course> getCourses() {
		return CourseService.getCourses();
	}

	@GetMapping("/{id}")
	public @ResponseBody Course getCourseByName(@PathVariable int id) {
		return CourseService.getCourseById(id);
	}

	@ExceptionHandler
	public ResponseEntity<CourseErrorResponse> handleException(ResourceNotFoundException ex) {
		return new ResponseEntity<>(
				new CourseErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis()),
				HttpStatus.NOT_FOUND);
	}

}
