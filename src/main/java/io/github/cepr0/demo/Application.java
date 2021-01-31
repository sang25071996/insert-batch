package io.github.cepr0.demo;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Application {
	
	private final ModelRepo repo;
	private final StudentRepo studentRepo;
	
	public Application(ModelRepo repo, StudentRepo studentRepo) {
		this.repo = repo;
		this.studentRepo = studentRepo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@EventListener
	@Transactional(rollbackOn = Exception.class)
	public void appReadyHandler(ApplicationReadyEvent e) {
		
//		repo.saveAll(IntStream.rangeClosed(1, 50)
//				.mapToObj(i -> new Model("mode" + i))
//				.collect(Collectors.toList())
//		);
		List<Student> listStudent = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			listStudent.add(new Student("student" + i));
		}
		this.studentRepo.saveAll(listStudent);
	}
}
