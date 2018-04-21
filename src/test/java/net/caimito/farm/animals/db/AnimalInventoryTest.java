package net.caimito.farm.animals.db;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import net.caimito.farm.animals.Animal;

public class AnimalInventoryTest {

	@Test
	public void listEmptyInventory() {
		AnimalInventory inventory = new AnimalInventory() ;
		
		assertThat(inventory.list(), is(emptyCollectionOf(Animal.class))) ;
	}
}
