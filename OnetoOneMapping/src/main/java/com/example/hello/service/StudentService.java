package com.example.hello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.dao.StudentRepository;
import com.example.hello.dto.AddressDto;
import com.example.hello.dto.StudentDto;
import com.example.hello.entity.AddressEntity;
import com.example.hello.entity.StudentDetails;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public void saveStudent(StudentDto studentDto) {
		StudentDetails studentDetails = new StudentDetails();
		AddressEntity addressEntity = new AddressEntity();
		studentDetails.setName(studentDto.getName());
		studentDetails.setFname(studentDto.getFname());
		addressEntity.setCountry(studentDto.getAddressDto().getCountry());
		addressEntity.setPinCode(studentDto.getAddressDto().getPinCode());
		addressEntity.setStreetLine1(studentDto.getAddressDto().getStreetLine1());
		studentDetails.setAddress(addressEntity);

		studentRepository.save(studentDetails);

	}

	public List<StudentDto> getall() {
		List<StudentDetails> studentDetails = studentRepository.findAll();
		List<StudentDto> studentDtos = convertEntityToDTO(studentDetails);
		return studentDtos;

	}

	public StudentDto getById(Long id) {
		Optional<StudentDetails> op = studentRepository.findById(id);
		if (op.isPresent()) {
			return convertEntityToDTO(op.get());
		}
		return null;
	}

	public List<StudentDto> getByName(String name) {
		List<StudentDetails> studentDetails = studentRepository.findByName(name);
		return convertEntityToDTO(studentDetails);
	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);

	}

	public void updateStudent(Long id, StudentDto studentDto) {
		Optional<StudentDetails> studentDetails = studentRepository.findById(id);
		if (studentDetails.isPresent()) {
			studentDetails.get().setName(studentDto.getName());
			studentDetails.get().setFname(studentDto.getFname());
			studentRepository.saveAndFlush(studentDetails.get());

		} else {
			// we need to throw exception here;
		}
	}

	private List<StudentDto> convertEntityToDTO(List<StudentDetails> studentDetails) {
		List<StudentDto> studentDtos = new ArrayList<>();
		for (int i = 0; i < studentDetails.size(); i++) {
			StudentDto studentDto = convertEntityToDTO(studentDetails.get(i));
			studentDtos.add(studentDto);

		}
		return studentDtos;

	}

	private StudentDto convertEntityToDTO(StudentDetails studentDetails) {

		StudentDto studentDto = new StudentDto();
		AddressDto addressDto = new AddressDto();
		if (studentDetails.getAddress() != null) {
			addressDto.setCountry(studentDetails.getAddress().getCountry());
			addressDto.setPinCode(studentDetails.getAddress().getPinCode());
			addressDto.setStreetLine1(studentDetails.getAddress().getStreetLine1());
		}
		studentDto.setName(studentDetails.getName());
		studentDto.setFname(studentDetails.getFname());
		studentDto.setId(studentDetails.getId());
		studentDto.setAddressDto(addressDto);
		return studentDto;
	}
}
