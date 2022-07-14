package com.qa.may.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.may.entity.Trainer;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Integer> {

	Trainer findByNameStartingWithIgnoreCase(String name);
}
