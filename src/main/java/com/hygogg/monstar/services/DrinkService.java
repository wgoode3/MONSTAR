package com.hygogg.monstar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hygogg.monstar.models.Drink;
import com.hygogg.monstar.repositories.DrinkRepository;

@Service
public class DrinkService {

    private final DrinkRepository drinkRepo;
    
    public DrinkService(DrinkRepository drinkRepo) {
        this.drinkRepo = drinkRepo;
    }
    
    public Drink create(Drink d) {
    	return drinkRepo.save(d);
    }

    public List<Drink> getAll() {
        return (List<Drink>) drinkRepo.findAll();
    }
    
    public Drink getOne(Long id) {
    	Optional<Drink> drink = drinkRepo.findById(id);
    	if(drink.isPresent()) {    		
    		return drink.get();
    	} else {
    		return null;
    	}
    }
    
    public Drink update(Drink d) {
    	return drinkRepo.save(d);
    }
    
    public void remove(Long id) {
    	drinkRepo.deleteById(id);
    }
    
}
