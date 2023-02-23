package com.dev.fab.projenum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.fab.projenum.repositories.OrderRepository;

@SpringBootApplication
public class ProjEnumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjEnumApplication.class, args);
	}

}
