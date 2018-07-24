package com.oocl.springBootApiDemo;

import com.oocl.springBootApiDemo.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class SpringBootApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiDemoApplication.class, args);
	}

	@Bean
    public List<Employee> allEmployees(){
	    List<Employee> allEmployees = new ArrayList<>();
	    allEmployees.add(new Employee(0, "小明", 20, "男"));
	    allEmployees.add(new Employee(1, "小红", 19, "女"));
	    allEmployees.add(new Employee(2, "小智", 15, "男"));
	    allEmployees.add(new Employee(3, "小刚", 16, "男"));
	    allEmployees.add(new Employee(4, "小霞", 15, "女"));
	    return allEmployees;
    }

}
