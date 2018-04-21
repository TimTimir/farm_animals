package net.caimito.farm.animals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class FarmManager {
	private Map<String, AnimalOriginAware> animals = new HashMap<>() ;

	public void purchaseFrom(Animal animal, Seller seller) {
		AnimalOriginAware originAwareAnimal = new AnimalOriginAware(animal, seller) ;
		animals.put(originAwareAnimal.getEid(), originAwareAnimal) ;
	}

	public Collection<AnimalOriginAware> listAnimalInventory() {
		return animals.values() ;
	}

}
