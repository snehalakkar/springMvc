package com.bridgeit.restControllerDemo.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.bridgeit.restControllerDemo.model.Student;

@Component
public class StudentDao {

	private static ArrayList<Student> studentList;
	{
		Student s1 = new Student(1, "snel", "coding");
		Student s2 = new Student(2, "chinu", "dansing");
		Student s3 = new Student(3, "soni", "badminton");

		studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public Student getStudent(int studId) {
		
		for (Student s : studentList) {
			if (s.getId() == studId) {
				return s;
			}
		}
		return null;
	}

	public Student updateStudent(int studId, Student student) {
		for (Student s : studentList) {
			if (s.getId() == studId) {
				student.setId(studId);
				studentList.remove(s);
				studentList.add(student);
				return student;
				
			}
		}
		return null;
	}

	public void postStudent(Student student) {
		studentList.add(student);
	}

	public long deleteStudent(int studId) {
		for (Student s : studentList) {
			if (s.getId() == studId) {
				studentList.remove(s);
				return studId;
			}
		}
		return (Integer) null;
	}

}