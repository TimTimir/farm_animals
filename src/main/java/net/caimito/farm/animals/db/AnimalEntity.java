package net.caimito.farm.animals.db;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.annotation.Id;

import net.caimito.farm.animals.Animal;
import net.caimito.farm.animals.Sex;
import net.caimito.farm.animals.Species;

public class AnimalEntity {
	@Id
	private String id;

	private String eid;
	private String species;
	private String sex ;
	private String purchasedFrom;
	
	private String name ;
	private String race ;
	private String color ;

	public AnimalEntity(String species, String eid) {
		this.species = species;
		this.eid = eid;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, true);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, true);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
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
		AnimalEntity entity = new AnimalEntity(animal.getSpecies().toString(), animal.getEid());
		
		if (animal.getSex() == null)
			throw new DataIntegrityViolationException(String.format("No sex specified for %s", animal)) ;
		
		entity.sex = animal.getSex().toString() ;
		entity.name = animal.getName() ;
		entity.race = animal.getRace() ;
		entity.color = animal.getColor() ;
		
		return entity ;
	}

	public Animal convertToAnimal() {
		Animal animal = new Animal(Species.valueOf(species), eid, determineSex());
		
		animal.setName(name);
		animal.setRace(race);
		animal.setColor(color);
		
		return animal ;
	}

	private Sex determineSex() {
		if (sex == null || sex.isEmpty())
			return Sex.UNKNOWN;
		else
			return Sex.valueOf(sex);
	}

	public void setPurchasedFrom(String name) {
		purchasedFrom = name;
	}
	
	public String getPurchasedFrom() {
		return purchasedFrom;
	}

}
