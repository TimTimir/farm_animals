package net.caimito.farm.animals.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import org.springframework.stereotype.Component;

import net.caimito.farm.animals.Animal;

@Component
public class AnimalInventory {
	
	private AnimalRepository repository ;
	
	public AnimalInventory(AnimalRepository animalRepository) {
		this.repository = animalRepository ;
	}

	public Collection<Animal> list() {
		Collection<Animal> animals = new ArrayList<>();
		
		for (AnimalEntity entity : repository.findAll()) {
			animals.add(entity.convertToAnimal()) ;
		}
		
		return animals ;
	}

	public void store(Animal animal) {
		AnimalEntity entity = AnimalEntity.instanceFrom(animal) ;
		entity.setId(UUID.randomUUID().toString()) ;
		
		repository.save(entity) ;
	}

}
