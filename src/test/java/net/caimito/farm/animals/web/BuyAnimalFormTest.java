package net.caimito.farm.animals.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import net.caimito.farm.animals.Animal;
import net.caimito.farm.animals.Seller;
import net.caimito.farm.animals.Species;

public class BuyAnimalFormTest {

	private BuyAnimalForm form ;

	@Before
	public void prepareForm() {
		form = new BuyAnimalForm() ;
		form.setEid("eid");
		form.setSeller("Juan");
		form.setSpecies(Species.SHEEP.toString());
	}
	
	@Test
	public void readAnimal() {
		Animal animal = form.readAnimal() ;
		
		assertThat(animal, is(not(nullValue())));
		assertThat(animal.getEid(), is(form.getEid())) ;
		assertThat(animal.getSpecies().toString(), is(form.getSpecies())) ;
	}
	
	@Test
	public void readSeller() {
		Seller seller = form.readSeller() ;
		
		assertThat(seller.getName(), is("Juan")) ;
	}

}
