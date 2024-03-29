package com.monisha.sms;

import com.monisha.sms.entity.Student;
import com.monisha.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student("Monisha","Dasari","monisha@gmail.com");
//		studentRepository.save(student1);
//
//		Student student2 = new Student("Kavya","Ahuja","kavya@gmail.com");
//		studentRepository.save(student2);
//
//		Student student3 = new Student("Priya","Mehta","priya@gmail.com");
//		studentRepository.save(student3);
	}
}
