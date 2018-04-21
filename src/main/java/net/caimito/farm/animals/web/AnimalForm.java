package net.caimito.farm.animals.web;

import net.caimito.farm.animals.Animal;
import net.caimito.farm.animals.Seller;
import net.caimito.farm.animals.Species;

public class AnimalForm {
	private String seller ;
	private String species ;
	private String eid ;
	
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}

	public Animal readForm() {
		Animal animal = new Animal(Species.valueOf(species), eid) ;
		animal.setOrigin(new Seller(this.seller)) ;
		return animal ;
	}

}
