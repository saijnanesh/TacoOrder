package com.taco.app.converter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.taco.app.model.Ingredient;

/*A converter is any class that implements
Spring’s Converter interface and implements its convert() method to take one
value and convert it to another. To convert a String to an Ingredient.
*/

/*IngredientByIdConverter is annotated with @Component to make
it discoverable as a bean in the Spring application context. Spring Boot autoconfiguration will discover this,
and any other Converter beans, 
and will automatically register them with Spring MVC to be used when the conversion of request parameters to
bound properties is needed*/

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

	private Map<String, Ingredient> map;

	public IngredientByIdConverter() {
		map = new HashMap<>();
		map.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Ingredient.TYPE.WRAP.name()));
		map.put("COTO", new Ingredient("COTO", "Corn Tortilla", Ingredient.TYPE.WRAP.name()));
		map.put("GRBF", new Ingredient("GRBF", "Ground Beef", Ingredient.TYPE.PROTEIN.name()));
		map.put("CARN", new Ingredient("CARN", "Carnitas", Ingredient.TYPE.PROTEIN.name()));
		map.put("TMTO", new Ingredient("TMTO", "Diced Tomatoes", Ingredient.TYPE.VEGGIES.name()));
		map.put("LETC", new Ingredient("LETC", "Lettuce", Ingredient.TYPE.VEGGIES.name()));
		map.put("CHED", new Ingredient("CHED", "Cheddar", Ingredient.TYPE.CHEESE.name()));
		map.put("JACK", new Ingredient("JACK", "Monterrey Jack", Ingredient.TYPE.CHEESE.name()));
		map.put("SLSA", new Ingredient("SLSA", "Salsa", Ingredient.TYPE.SAUCE.name()));
		map.put("SRCR", new Ingredient("SRCR", "Sour Cream", Ingredient.TYPE.SAUCE.name()));
	}

	@Override
	public Ingredient convert(String id) {
		return map.get(id);
	}

}
