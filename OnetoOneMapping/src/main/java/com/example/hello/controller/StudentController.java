package com.example.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.dto.StudentDto;
import com.example.hello.service.StudentService;

@RestController

public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody StudentDto studentDto) {
		studentService.saveStudent(studentDto);
		return ResponseEntity.ok("saved successfully");
	}

	@GetMapping("/getall")
	public List<StudentDto> getall() {
		return studentService.getall();
	}

	@GetMapping("getbyid/{id}")
	public StudentDto getById(@PathVariable("id") Long id) {
		return studentService.getById(id);
	}

	@GetMapping("getbyname/{name}")
	public List<StudentDto> getByName(@PathVariable("name") String name) {
		return studentService.getByName(name);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.ok("student deleted succesfully");
	}

	@PutMapping("update/{id}")
	public ResponseEntity updateStudent(@PathVariable("id") Long id, @RequestBody StudentDto studentDto) {
		studentService.updateStudent(id, studentDto);
		return new ResponseEntity(HttpStatus.OK);
	}
//
//    @GetMapping("/getALL")
//    public ArrayList<StudentDto>getALL(){
//        return studentService.getStudentDtos();
//    }
//    @GetMapping("getbyid/{id}")
//    public StudentDto getByid(@PathVariable("id") int id){
//return studentService.getByid(id);
//    }
//    @GetMapping("getbyname/{name}")
//    public List<StudentDto> getByname(@PathVariable("name") String name){
//        return studentService.getByname(name);
//    }
//    @GetMapping("getbyini/{ini}")
//    public List<StudentDto> getByini(@PathVariable("name")String name){
//        return studentService.getByini(name);
//    }
//    @GetMapping("getbycountry/{country}")
//    public List<String>getBycountry(@PathVariable("country")String country){
//        return studentService.getBycountry(country);
//    }

}
