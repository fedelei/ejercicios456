package com.example.ejercicios456;

import com.example.ejercicios456.entidad.Laptop;
import com.example.ejercicios456.repositorio.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicios456Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicios456Application.class, args);

		LaptopRepository repositorio = context.getBean(LaptopRepository.class);

		//Crear objetos Laptops
		Laptop lap1 = new Laptop(null, "Acer", "Ultimate", "Black", "Windows10", 200.50);
		Laptop lap2 = new Laptop(null,"HP","standard", "Plateado", "Windows10", 350.00);
		Laptop lap3 = new Laptop(null, "Apple", "22", "Black", "IOs", 550.33);

		//Guardando objetos en el Repositorio
		repositorio.save(lap1);
		repositorio.save(lap2);
		repositorio.save(lap3);
	}

}
