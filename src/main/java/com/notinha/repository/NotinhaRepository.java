package com.notinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notinha.entidades.Notinha;

public interface NotinhaRepository extends JpaRepository<Notinha, Integer> {

	
}
