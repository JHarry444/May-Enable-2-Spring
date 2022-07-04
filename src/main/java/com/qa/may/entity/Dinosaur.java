package com.qa.may.entity;

public class Dinosaur {

	private String name;

	private String species;

	private int age;

	public Dinosaur() {
		super();
	}

	public Dinosaur(String name, String species, int age) {
		super();
		this.name = name;
		this.species = species;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return this.species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dinosaur [name=" + this.name + ", species=" + this.species + ", age=" + this.age + "]";
	}

}
