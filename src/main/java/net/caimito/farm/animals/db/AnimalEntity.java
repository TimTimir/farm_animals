package net.caimito.farm.animals.db;

import org.springframework.data.annotation.Id;

public class AnimalEntity {

	@Id
	private String id ;
	
	private String eid;
	private String species;

	public AnimalEntity(String species, String eid) {
		this.species = species ;
		this.eid = eid ;
	}

}
