package net.caimito.farm.animals.db;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.caimito.farm.animals.Animal;
import net.caimito.farm.animals.Species;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@EnableMongoRepositories(basePackages = "net.caimito.farm.animals.db")
public class AnimalInventoryITest {

	@Autowired
	private AnimalRepository animalRepository ;
	
	@Test
	public void listEmptyInventory() {
		AnimalInventory inventory = new AnimalInventory(animalRepository) ;
		
		assertThat(inventory.list(), is(emptyCollectionOf(Animal.class))) ;
	}
	
	@Test
	public void addAnimalToInventory() {
		Animal animalExpected = new Animal(Species.SHEEP, "abc") ;
		
		AnimalInventory inventory = new AnimalInventory(animalRepository) ;
		inventory.store(new Animal(Species.SHEEP, "abc")) ;
		
		assertThat(inventory.list(), is(hasItem(animalExpected))) ;
		
	}
}
