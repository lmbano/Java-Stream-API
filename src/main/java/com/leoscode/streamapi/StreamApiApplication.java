package com.leoscode.streamapi;

import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class StreamApiApplication {

	static List<Employee> employees=new ArrayList<>();

	static{

		employees.add(
				new Employee("Leon", "Mbano",4500.00, Arrays.asList("Project 1", "Project 2")));
		employees.add(
				new Employee("Fadzai", "Mbano",200.00, Arrays.asList("Project 3", "Project 2")));
		employees.add(
				new Employee("Tanya", "Truerr",140.00, Arrays.asList("Project 4", "Project 1")));
		employees.add(
				new Employee("Bryne", "Mbano",345.00, Arrays.asList("Project 3", "Project 3")));
		employees.add(
				new Employee("Alex", "Moyo",700.00, Arrays.asList("Project 1", "Project 3")));
		employees.add(
				new Employee("Praise", "Marufu",1200.00, Arrays.asList("Project 1", "Project 2")));


	}

	public static void main(String[] args) {

		//SpringApplication.run(StreamApiApplication.class, args);
// foreach
		employees.stream()
				.forEach(employee -> System.out.println(employee));

		// map  can use set, lis on collectors to get the desired collection
		List<Employee> increaseSalasy =employees.stream()
				.map(employee -> new Employee(
						employee.getFirstname(),
						employee.getLastname(),
						employee.getSalary() * 1.59,
						employee.getProjects()
				)).collect(Collectors.toList());

		System.out.println(increaseSalasy);

		// filter operation
		List<Employee> filterEmp=employees.stream()
				.filter(employee -> employee.getSalary() > 1000.00)
				.map(employee -> new Employee(
				employee.getFirstname(),
				employee.getLastname(),
				employee.getSalary() * 1.59,
				employee.getProjects()
		)).collect(Collectors.toList());

		System.out.println(filterEmp);

		// findFirst operation
		Employee first =employees.stream()
				.filter(employee -> employee.getSalary() > 10000.00)
				.map(employee -> new Employee(
						employee.getFirstname(),
						employee.getLastname(),
						employee.getSalary() * 1.59,
						employee.getProjects()
				))
				.findFirst()
				.orElse(null);

		System.out.println(first);


		// flatMap operation

		String projects= employees
			.stream()
			.map(employee -> employee.getProjects())
			.flatMap(strings -> strings.stream())
			.collect(Collectors.joining(","));

		System.out.println(projects);

	}

}
