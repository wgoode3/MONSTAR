package com.hygogg.monstar.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hygogg.monstar.models.Drink;
import com.hygogg.monstar.repositories.DrinkRepository;

@Service
public class DrinkService {

    private final DrinkRepository drinkRepo;
    
    public DrinkService(DrinkRepository drinkRepo) {
        this.drinkRepo = drinkRepo;
    }
    
    public List<Drink> getAll() {
        return (List<Drink>) drinkRepo.findAll();
    }
    
    public Drink create(Drink d) {
    	return drinkRepo.save(d);
    }
    
}
