package com.hygogg.monstar.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hygogg.monstar.models.Drink;

@Repository
public interface DrinkRepository extends CrudRepository<Drink, Long> {}
