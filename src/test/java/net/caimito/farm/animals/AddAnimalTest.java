package net.caimito.farm.animals;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class AddAnimalTest {

	private FarmManager farmManager = new FarmManager() ;
	private Animal animal = new Animal(Species.SHEEP, "eid") ;
	private Seller seller = new Seller("Juan") ;

	@Test
	public void purchaseAnimal() {
		farmManager.purchaseFrom(animal, seller) ;
		
		assertThat(farmManager.listAnimalInventory(), hasItem(animal));
	}

	@Test
	public void animalHasPurchaseHistory() {
		farmManager.purchaseFrom(animal, seller) ;
		Animal animalOnFarm = farmManager.listAnimalInventory().iterator().next() ;
		
		assertThat(animalOnFarm.isOfOrigin(seller), is(true)) ;
	}
}
