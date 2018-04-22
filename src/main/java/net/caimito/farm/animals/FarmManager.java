package net.caimito.farm.animals;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import net.caimito.farm.animals.db.AnimalEntity;
import net.caimito.farm.animals.db.AnimalRepository;

@Component
public class FarmManager {
	
	private AnimalRepository animalRepository;

	public FarmManager(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository ;
	}
	
	public void purchaseFrom(Animal animal, Seller seller) {
		AnimalEntity entity = animalRepository.findByEid(animal.getEid()) ;
		if (entity == null)
			entity = AnimalEntity.instanceFrom(animal) ;
		
		entity.setPurchasedFrom(seller.getName()) ;
		
		animalRepository.save(entity) ;
	}

	public Collection<Animal> listAnimalInventory() {
		Collection<Animal> animals = new ArrayList<>() ;
		
		for (AnimalEntity entity : animalRepository.findAll()) {
			animals.add(entity.convertToAnimal()) ;
		}
		
		return animals ;
	}

	public void reportDead(Animal animal) {
		AnimalEntity entity = animalRepository.findByEid(animal.getEid()) ;
		animalRepository.deleteById(entity.getId());
	}

	public Seller findOrigin(Animal animalOnFarm) {
		AnimalEntity entity = animalRepository.findByEid(animalOnFarm.getEid()) ;
		return new Seller(entity.getPurchasedFrom()) ;
	}

}
