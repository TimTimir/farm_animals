package net.caimito.farm.animals;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Animal {

	private String eid;
	private Seller origin;
	private Species species;

	public Animal(Species species, String eid) {
		this.species = species ;
		this.eid = eid ;
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

	public boolean isOfOrigin(Seller seller) {
		return seller.equals(origin) ;
	}

	public void setOrigin(Seller seller) {
		this.origin = seller ;
	}

	public Species getSpecies() {
		return species ;
	}

}
