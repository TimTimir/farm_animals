package net.caimito.farm.animals.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import net.caimito.farm.animals.Animal;
import net.caimito.farm.animals.Seller;
import net.caimito.farm.animals.Species;

public class AnimalFormTest {

	@Test
	public void convertToDomainObject() {
		AnimalForm form = new AnimalForm() ;
		form.setEid("eid");
		form.setSeller("Juan");
		form.setSpecies(Species.SHEEP.toString());
		
		Animal animal = form.readForm() ;
		
		assertThat(animal, is(not(nullValue())));
		assertThat(animal.getEid(), is(form.getEid())) ;
		assertThat(animal.isOfOrigin(new Seller(form.getSeller())), is(true)) ;
		assertThat(animal.getSpecies().toString(), is(form.getSpecies())) ;
	}

}
