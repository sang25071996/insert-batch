package io.github.cepr0.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity()
@Table(name = "STUDENT", schema = "MODELS")
public class Student {
	
	@Id
	@SequenceGenerator(name="student_id_seq",sequenceName="student_id_seq", allocationSize=20)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_id_seq")
	
	private Long id;
	private String name;
	
	public Student(String name) {
		this.name = name;
	}
}
