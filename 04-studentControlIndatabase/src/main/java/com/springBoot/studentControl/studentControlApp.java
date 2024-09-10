package com.springBoot.studentControl;


import com.springBoot.studentControl.entity.Student;
import com.springBoot.studentControl.DAO.StudentDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class studentControlApp {

	Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		SpringApplication.run(studentControlApp.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired StudentDaoService studentDaoService) {
		return commandLineRunner ->{

			deleteAll(studentDaoService);


		};
	}
	public void createStudent(StudentDaoService studentDaoService){
		System.out.println("Öğrenci Adı: ");String firstName=scanner.nextLine();
		System.out.println("Öğrenci Soyadı: ");String lastName=scanner.nextLine();
		System.out.println("Öğrenci Email: ");String email=scanner.nextLine();
		Student student=new Student(firstName,lastName,email);
		studentDaoService.save(student);

	}
	public void readStudent(StudentDaoService studentDaoService){
		System.out.println("Lütfen öğrenci id numarasını giriniz: "); Integer id=scanner.nextInt();
		Student student=studentDaoService.getById(id);
		if (student==null){
			System.out.println("Sistemde böyle bir öğrenci bulunamadı");
		}
		else {
			System.out.println(student.toString());
		}
	}
	public void getAll(StudentDaoService studentDaoService){
		for (Student student : studentDaoService.getAll()) {
			System.out.println(student.toString());
		}
	}

	public void findBySurname(StudentDaoService studentDaoService){
		System.out.println("Lütfen hangi ada sahip kişileri bulmak istediğinizi yazınız");String wantedName=scanner.nextLine();
		studentDaoService.findBySurname(wantedName);
	}

	public void update(StudentDaoService studentDaoService){
		System.out.println("Güncellemek istediğiniz öğrencinin id numarasını giriniz: "); Integer id=scanner.nextInt();
		Student gonnaUpdate=studentDaoService.getById(id);
		System.out.println(gonnaUpdate);
		System.out.println("Adını güncellemek için 1\n" +
				           "Soyadının güncellemek için 2\n" +
				            "email güncellemek için 3'ü tuşlayınız");int choose=scanner.nextInt();scanner.nextLine();

		switch (choose){
			case 1:

				System.out.println("Yeni adını giriniz: ");String newName=scanner.nextLine();
				gonnaUpdate.setFirstName(newName);
				break;
			case 2:
				System.out.println("Yeni soyadı giriniz: ");String newSurname=scanner.nextLine();
				gonnaUpdate.setLastName(newSurname);
				break;
			case 3:
				System.out.println("Yeni emaili giriniz: ");String newEmail=scanner.nextLine();
				gonnaUpdate.seteMail(newEmail);
				break;
		}
		studentDaoService.update(gonnaUpdate);
		System.out.println(gonnaUpdate);
	}

	public void delete(StudentDaoService studentDaoService){
		System.out.println("Lütfen silmek istediğiniz öğrencinin id numarasını giriniz: ");Integer id=scanner.nextInt();
		studentDaoService.delete(id);
		System.out.println("Kişi başarı ile silindi");
	}
	public void deleteAll(StudentDaoService studentDaoService){
		int deleted=studentDaoService.deleteAll();
		System.out.println(deleted+" kişi veri tabanından silindi");
	}

}
