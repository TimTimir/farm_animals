package net.caimito.farm.animals.web;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.builder.ToStringBuilder;

import net.caimito.farm.animals.Animal;
import net.caimito.farm.animals.Seller;
import net.caimito.farm.animals.Species;

public class BuyAnimalForm {
	
	@NotBlank
	private String seller ;

	@NotBlank
	private String species ;

	@NotBlank
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
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this) ;
	}

	public Animal readAnimal() {
		return new Animal(Species.valueOf(species), eid) ;
	}
	public Seller readSeller() {
		return new Seller(seller) ;
	}
	
}
