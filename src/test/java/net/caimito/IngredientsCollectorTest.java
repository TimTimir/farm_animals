package net.caimito;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class IngredientsCollectorTest {
	
	@Test
	public void twoIngredients() {
		List<Ingredient> ingredientList = new ArrayList<>() ;
		ingredientList.add(new Ingredient(1, "pcs", "Egg")) ;
		ingredientList.add(new Ingredient(1, "pcs", "Something")) ;
		
		IngredientsCollector collector = new IngredientsCollector() ;
		assertThat(collector.collect(ingredientList), hasItem(new Ingredient(1, "pcs", "Egg"))) ;
		assertThat(collector.collect(ingredientList), hasItem(new Ingredient(1, "pcs", "Something"))) ;
	}
	
	@Test
	public void collectIngredients() {
		List<Ingredient> ingredientList = new ArrayList<>() ;
		ingredientList.add(new Ingredient(1, "pcs", "Egg")) ;
		ingredientList.add(new Ingredient(1, "pcs", "Egg")) ;
		
		IngredientsCollector collector = new IngredientsCollector() ;
		assertThat(collector.collect(ingredientList), hasItem(new Ingredient(2, "pcs", "Egg"))) ;
	}

	@Test(expected=UnitsDontMatchException.class)
	public void differentUnits() {
		List<Ingredient> ingredientList = new ArrayList<>() ;
		ingredientList.add(new Ingredient(1, "pcs", "Egg")) ;
		ingredientList.add(new Ingredient(1, "Stück", "Egg")) ;
		
		IngredientsCollector collector = new IngredientsCollector() ;
		collector.collect(ingredientList) ;
	}

}
