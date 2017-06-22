package com.bridgeit.restControllerDemo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bridgeit.restControllerDemo.dao.StudentDao;
import com.bridgeit.restControllerDemo.model.Student;


@RestController
public class StudentController {

	@Autowired
	StudentDao StudentDaoImplementation;
	
	//returning all students record
	@RequestMapping(value="/students" ,method=RequestMethod.GET)
	public ArrayList<Student> getStudentList(){
		
		return StudentDaoImplementation.getStudentList();
		
	}
	
	//return particular student record with specifying the which type of response it wants
	@RequestMapping(value="/students/{id}" ,method=RequestMethod.GET,produces=MediaType.APPLICATION_XML_VALUE)
	public Student getStudent(@PathVariable("id") int studId){
		
	Student student= StudentDaoImplementation.getStudent(studId);
	return student;
		
	}
	
	/*//for put type of request where client can update the student record in DB by providing name and along with name client have to specify the json/xml formate data in content type using postman  
	@RequestMapping(value="/students/{id}" ,method=RequestMethod.PUT)
	public boolean updateStudent(@PathVariable("id") int studId ,@RequestBody Student student){
		
		 student= StudentDaoImplementation.updateStudent(studId,student);
		 
		 if(student==null){
			 return false;
		 }
		return true;
	}*/
	
	//for put type of request where client can update the student record in DB by providing name and along with name client have to specify the json/xml formate data in content type using postman  
		@RequestMapping(value="/students/{id}" ,method=RequestMethod.PUT)
		public ResponseEntity updateStudent(@PathVariable("id") int studId ,@RequestBody Student student){
			
			 student= StudentDaoImplementation.updateStudent(studId,student);
			 
			 if(student==null){
				 return new ResponseEntity("no customer found at id:"+studId,HttpStatus.NOT_FOUND);
			 }
			 return new ResponseEntity(" customer found at id:"+studId,HttpStatus.OK);
		}
		
		//for post request which will add the new resourse to the server
		@RequestMapping(value="/students" ,method=RequestMethod.POST,consumes=MediaType.APPLICATION_XML_VALUE)
		public ResponseEntity<Boolean> postStudent(@RequestBody Student student){
			
			StudentDaoImplementation.postStudent(student);
			
			HttpHeaders httpHeaders=new HttpHeaders();
			httpHeaders.add("location", ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(student.getId()).toUri().toString());
			 
			 return new ResponseEntity<Boolean>(true,httpHeaders,HttpStatus.CREATED);
		}
		
		//for delete type of request where client can delete the student record in DB by providing name   
				@RequestMapping(value="/students/{id}" ,method=RequestMethod.DELETE)
				public ResponseEntity deleteStudent(@PathVariable("id") int studId){
					
				int id= (int)StudentDaoImplementation.deleteStudent(studId);
					 if(id == 0){
					 return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
				 }
					return new ResponseEntity<Boolean>(true,HttpStatus.OK);
				}
}

