package com.example.demo;

import com.example.demo.entity.Car;
import com.example.demo.entity.Owner;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class HorsesApplication implements CommandLineRunner {
		private static final Logger logger = LoggerFactory.getLogger(HorsesApplication.class);
		@Autowired
		private CarRepository carRepository;
		@Autowired

		private OwnerRepository ownerRepository;

		public static void main(String[] args) {

			SpringApplication.run(HorsesApplication.class, args);
			logger.info("HorsesApplication started");

		}


		@Override
		public void run(String... args) throws Exception {
			Owner owner1 = new Owner("Ray", "Nick");
			Owner owner2 = new Owner("Lisa", "Bob");
			ownerRepository.save(owner1);
			ownerRepository.save(owner2);
			List<Car> cars = Arrays.asList(
					new Car("Ford", "Mustang", "Red", "ADF_1121", 2021, 49000, owner1),
					new Car("Nissan", "Leaf", "Gray", "EBF_1221", 2020, 32500, owner2),
					new Car("Toyota", "Camry", "Silver", "CDF_3123", 2021, 32000, owner1),
					new Car("Honda", "Accord", "White", "DDF_3421", 2023, 40000, owner2)
			);
			carRepository.saveAll(cars);
// fetch all cars and log to console
			carRepository.findAll().forEach(car -> logger.info(car.getMake() + " " + car.getModel()));


	}


}
