package com.qa.may.dto;

import java.util.List;

public class TrainerDTO {

	private Integer id;

	private String name;

	private List<DinoDTO> dinos;

	public TrainerDTO() {
		super();
	}

	public TrainerDTO(Integer id, String name, List<DinoDTO> dinos) {
		super();
		this.id = id;
		this.name = name;
		this.dinos = dinos;
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

	public List<DinoDTO> getDinos() {
		return this.dinos;
	}

	public void setDinos(List<DinoDTO> dinos) {
		this.dinos = dinos;
	}

}
