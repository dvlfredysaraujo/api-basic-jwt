package com.cardatabase.demo;

import com.cardatabase.demo.domain.Car;
import com.cardatabase.demo.domain.Owner;
import com.cardatabase.demo.domain.User;
import com.cardatabase.demo.repository.CarRepository;
import com.cardatabase.demo.repository.OwnerRepository;
import com.cardatabase.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			Owner owner1 = new Owner("Fred", "Ara");
			Owner owner2 = new Owner("Juan", "Peña");

			ownerRepository.save(owner1);
			ownerRepository.save(owner2);

			repository.save(new Car("Ford", "Mustang", "Red",
					"ADF-1121", 2017, 59000, owner1
			));
			repository.save(new Car("Nissan", "Leaf", "White",
					"SSJ-3002", 2014, 29000, owner2));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212",
					2018, 39000, owner2));

			//username: user password: user
			userRepository.save(new User("user",
					"$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
					"USER"
			));
			// username: admin password: admin
			userRepository.save(new User("admin",
					"$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
					"ADMIN"
			));

		};
	}

}
