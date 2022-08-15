package com.qa.may.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.may.entity.Dinosaur;

@Repository
public interface DinoRepo extends JpaRepository<Dinosaur, Integer> {

	Dinosaur findByNameStartingWithIgnoreCase(String name);
}
