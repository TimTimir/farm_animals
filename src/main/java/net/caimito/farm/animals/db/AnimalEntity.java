package net.caimito.farm.animals.db;

import org.springframework.data.annotation.Id;

import net.caimito.farm.animals.Animal;
import net.caimito.farm.animals.Species;

public class AnimalEntity {

	@Id
	private String id ;
	
	private String eid;
	private String species;

	public AnimalEntity(String species, String eid) {
		this.species = species ;
		this.eid = eid ;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public static AnimalEntity instanceFrom(Animal animal) {
		return new AnimalEntity(animal.getSpecies().toString(), animal.getEid()) ;
	}

	public Animal convertToAnimal() {
		return new Animal(Species.valueOf(species), eid) ;
	}

}
