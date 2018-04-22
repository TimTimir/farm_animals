package net.caimito.farm.animals.web;

import javax.validation.constraints.NotBlank;

public class SearchForm {

	@NotBlank
	private String eid ;

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}
	
}
