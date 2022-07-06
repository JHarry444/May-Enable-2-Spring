package com.qa.may.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Table
public class Dinosaur {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Integer id;

	@Column(name = "dinoName", nullable = false, unique = true)
	private String name;

	private String species;

	private int age;

	public Dinosaur() {
		super();
		// REQUIRED
	}

	public Dinosaur(String name, String species, int age) {
		super();
		this.name = name;
		this.species = species;
		this.age = age;
	}

	public Dinosaur(Integer id, String name, String species, int age) {
		super();
		this.id = id;
		this.name = name;
		this.species = species;
		this.age = age;
	}

	// REQUIRED

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.age;
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.species == null) ? 0 : this.species.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dinosaur other = (Dinosaur) obj;
		if (this.age != other.age)
			return false;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		if (this.species == null) {
			if (other.species != null)
				return false;
		} else if (!this.species.equals(other.species))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dinosaur [name=" + this.name + ", species=" + this.species + ", age=" + this.age + "]";
	}

}
