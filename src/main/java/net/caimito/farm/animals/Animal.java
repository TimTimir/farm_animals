package net.caimito.farm.animals;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Animal {

	private String eid;
	private Species species;
	private Sex sex ;
	private String name ;
	private String race ;
	private String color ;
	
	public Animal() {
	}

	public Animal(Species species, String eid, Sex sex) {
		this.species = species ;
		this.eid = eid ;
		this.sex = sex ;
	}

	public String getEid() {
		return eid ;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, true) ;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, true) ;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public Species getSpecies() {
		return species ;
	}

	public Sex getSex() {
		return sex;
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
	
}
