package com.lombok.demolombok;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemolombokApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemolombokApplication.class, args);
		// SINGLETON
		Persona persona = Singleton.getPersona("Juan", 23);
		
		// PROTOTYPE
		Vehicle car = new Car();
		
		// BUILDER
		Ship ship = ShipBuilder.build("Titanik", 50, 23000);
	}
}

class Persona {
	private  String name;
	private int age;
	
	public Persona(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}

class Singleton {
	private static Persona persona;
	
	public static Persona getPersona(String name, int age) {
		if (persona == null) {
			persona = new Persona(name, age);
		} 
		return persona;
	}
}

interface Vehicle {
	 public void start();
	}

class Car implements Vehicle {

	@Override
	public void start() {
		System.out.print("Car started");

	}

}

interface Builder {
	void setModel (String model);
	void setSize (int size);
	void setWeight (int weight);
}

class ShipBuilder implements Builder {
	private static String model;
	private static int size;
	private static int weight;

	@Override
	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public static Ship build(String model, int size, int weight) {
		return new Ship(model, size, weight);
	}
}

class Ship {
	private String model;
	private int size;
	private int weight;
	
	public Ship(String model, int size, int weight) {
		this.model = model;
		this.size = size;
		this.weight = weight;
	}
}

