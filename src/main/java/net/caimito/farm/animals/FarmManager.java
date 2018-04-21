package net.caimito.farm.animals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FarmManager {
	private Map<String, Animal> animals = new HashMap<>() ;

	public void purchaseFrom(Animal animal, Seller seller) {
		animal.setOrigin(seller) ;
		animals.put(animal.getEid(), animal) ;
	}

	public Collection<Animal> listAnimalInventory() {
		return animals.values() ;
	}

}
