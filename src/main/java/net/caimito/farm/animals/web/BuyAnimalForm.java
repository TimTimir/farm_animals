package net.caimito.farm.animals.web;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.builder.ToStringBuilder;

import net.caimito.farm.animals.Animal;
import net.caimito.farm.animals.Seller;
import net.caimito.farm.animals.Sex;
import net.caimito.farm.animals.Species;

public class BuyAnimalForm {
	
	@NotBlank
	private String seller ;

	@NotBlank
	private String species ;

	@NotBlank
	private String eid ;
	
	@NotBlank
	private String sex ;

	private String name ;
	private String race ;
	private String color ;
	
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this) ;
	}

	public Animal readAnimal() {
		Animal animal = new Animal(Species.valueOf(species), eid, Sex.valueOf(sex)) ;
		
		animal.setName(name);
		animal.setRace(race);
		animal.setColor(color);
		
		return animal ;
	}
	
	public Seller readSeller() {
		return new Seller(seller) ;
	}
	
}
