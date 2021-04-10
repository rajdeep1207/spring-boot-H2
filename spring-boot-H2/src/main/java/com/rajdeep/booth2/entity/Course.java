package com.rajdeep.booth2.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String branch;
	
	@OneToMany(targetEntity = Review.class,cascade=CascadeType.ALL)
	@JoinColumn(name="c_id",referencedColumnName = "id")
	private List<Review> reviews;
}
