package com.taco.app.model;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Taco {

	@NotNull
	@Min(value = 5, message = "Name should contain min of 5 char long")
	private String name;
	
	@NotNull
	private List<Ingredient> ingredient;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredient() {
		return ingredient;
	}

	public void setIngredient(List<Ingredient> ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public String toString() {
		return "Taco [name=" + name + ", ingredient=" + ingredient + "]";
	}

}
