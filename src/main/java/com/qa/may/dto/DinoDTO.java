package com.qa.may.dto;

public class DinoDTO {

	private Integer id;

	private String name;

	private Integer age;

	private String species;

	private Integer trainerId;

	public DinoDTO() {
		super();
	}

	public DinoDTO(Integer id, String name, Integer age, String species, Integer trainerId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.species = species;
		this.trainerId = trainerId;
	}

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

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSpecies() {
		return this.species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public Integer getTrainerId() {
		return this.trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

}
