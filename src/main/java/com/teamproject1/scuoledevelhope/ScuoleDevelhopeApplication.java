package com.teamproject1.scuoledevelhope;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.register.Register;
import com.teamproject1.scuoledevelhope.classes.student.Student;
import com.teamproject1.scuoledevelhope.classes.student.studentDAO.StudentDAO;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.dao.UserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;


@SpringBootApplication
public class ScuoleDevelhopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScuoleDevelhopeApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO, UserDao userDao){
		return runner ->{
/*
			User user = new User("Willo","Gattone");

			userDao.save(user);
			Classes classes = null;
			Register register = null;
			Student student = new Student(user,classes,register);
			studentDAO.save(student);
			//System.out.println(UUID.randomUUID());*/
		};

		}
}

