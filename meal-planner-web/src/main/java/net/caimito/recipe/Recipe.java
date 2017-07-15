package net.caimito.recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import net.caimito.Ingredient;

public class Recipe {
	private String id = "";
	private String name = "";
	private String description = "";
	private String yield = "";
	private List<Ingredient> ingredients = new ArrayList<>();
	private List<String> instructions = new ArrayList<>();

	public Recipe() {
		this.id = UUID.randomUUID().toString() ;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getYield() {
		return yield;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public List<String> getInstructions() {
		return instructions;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setYield(String yield) {
		this.yield = yield;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this) ;
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj) ;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this) ;
	}
}
