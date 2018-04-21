package net.caimito.farm.animals;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf;
import static org.junit.Assert.*;

import org.junit.Test;

public class FarmManagerTest {

	private FarmManager farmManager = new FarmManager() ;
	private Seller seller = new Seller("Juan") ;

	@Test
	public void noAnimals() {
		assertThat(farmManager.listAnimalInventory(), is(emptyCollectionOf(AnimalOriginAware.class))) ;
	}
	
	@Test
	public void purchaseAnimal() {
		AnimalOriginAware animal = new AnimalOriginAware(Species.SHEEP, "eid", seller) ;
		farmManager.purchaseFrom(animal, seller) ;
		
		assertThat(farmManager.listAnimalInventory(), hasItem(animal));
	}

	@Test
	public void animalHasPurchaseHistory() {
		Animal animal = new Animal(Species.SHEEP, "eid") ;
		
		farmManager.purchaseFrom(animal, seller) ;
		AnimalOriginAware animalOnFarm = farmManager.listAnimalInventory().iterator().next() ;
		
		assertThat(animalOnFarm.isOfOrigin(seller), is(true)) ;
	}
}
