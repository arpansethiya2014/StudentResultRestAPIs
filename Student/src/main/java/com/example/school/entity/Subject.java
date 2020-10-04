package com.example.school.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subjectId;
	private double english;
	private double hindi;
	private double maths;
	private double chemistry;
	private double physics;
	private String rollNumber;
	private String year;

	public Subject() {
	}

	public Subject(double english, double hindi, double maths, double chemistry, double physics, String rollNumber,
			String year) {
		this.english = english;
		this.hindi = hindi;
		this.maths = maths;
		this.chemistry = chemistry;
		this.physics = physics;
		this.rollNumber = rollNumber;
		this.year = year;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public double getEnglish() {
		return english;
	}

	public void setEnglish(double english) {
		this.english = english;
	}

	public double getHindi() {
		return hindi;
	}

	public void setHindi(double hindi) {
		this.hindi = hindi;
	}

	public double getMaths() {
		return maths;
	}

	public void setMaths(double maths) {
		this.maths = maths;
	}

	public double getChemistry() {
		return chemistry;
	}

	public void setChemistry(double chemistry) {
		this.chemistry = chemistry;
	}

	public double getPhysics() {
		return physics;
	}

	public void setPhysics(double physics) {
		this.physics = physics;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
