package net.caimito.farm.animals;

public class AnimalOriginAware extends Animal {

	private Seller origin;

	public AnimalOriginAware(Species species, String eid, Seller origin) {
		super(species, eid);
		this.origin = origin ;
	}

	public AnimalOriginAware(Animal animal, Seller origin) {
		this(animal.getSpecies(), animal.getEid(), origin) ;
	}

	public boolean isOfOrigin(Seller seller) {
		return seller.equals(origin) ;
	}

}
