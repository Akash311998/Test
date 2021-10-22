package com.example.hello;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.hello.dao.StudentRepository;
import com.example.hello.dto.StudentDto;
import com.example.hello.entity.StudentDetails;
import com.example.hello.service.StudentService;

@SpringBootTest
class StudenServiceTest {

	@InjectMocks
	private StudentService injectService;

	@Mock
	private StudentRepository studentRepository;

	@Test
	void testGetall() {

		Mockito.when(studentRepository.findAll()).thenReturn(getStudentDTOList());

		List<StudentDto> dtos = injectService.getall();
		Assert.notNull(dtos);
		Assert.isTrue(dtos.size() == 1);

	}

	private List<StudentDetails> getStudentDTOList() {
		List<StudentDetails> details = new ArrayList<>();
		details.add(new StudentDetails());
		return details;
	}

}
