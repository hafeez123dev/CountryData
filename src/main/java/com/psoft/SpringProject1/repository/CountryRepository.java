package com.psoft.SpringProject1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psoft.SpringProject1.entity.Country;

@Repository
	public interface CountryRepository extends JpaRepository<Country, String> {

	
	}

