package com.taco.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.taco.app.model.Ingredient;
import com.taco.app.model.Ingredient.TYPE;
import com.taco.app.model.Taco;
import com.taco.app.model.TacoOrder;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

	public static final org.slf4j.Logger logger = LoggerFactory.getLogger("DesignTacoController");

	/*
	 * @ModelAttribute will create model object and assign it to the showDesignForm
	 */
	
	@ModelAttribute
	public void addIngredientsToTheOrder(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("FLTO", "Flour Tortilla", Ingredient.TYPE.WRAP.name()),
				new Ingredient("COTO", "Corn Tortilla", Ingredient.TYPE.WRAP.name()),
				new Ingredient("GRBF", "Ground Beef", Ingredient.TYPE.PROTEIN.name()),
				new Ingredient("CARN", "Carnitas", Ingredient.TYPE.PROTEIN.name()),
				new Ingredient("TMTO", "Diced Tomatoes", Ingredient.TYPE.VEGGIES.name()),
				new Ingredient("LETC", "Lettuce", Ingredient.TYPE.VEGGIES.name()),
				new Ingredient("CHED", "Cheddar", Ingredient.TYPE.CHEESE.name()),
				new Ingredient("JACK", "Monterrey Jack", Ingredient.TYPE.CHEESE.name()),
				new Ingredient("SLSA", "Salsa", Ingredient.TYPE.SAUCE.name()),
				new Ingredient("SRCR", "Sour Cream", Ingredient.TYPE.SAUCE.name()));

		TYPE[] type = Ingredient.TYPE.values();
		for (TYPE t : type) {
			model.addAttribute(t.name().toLowerCase(), filterBy(ingredients, t));
		}
	}

	private Iterable<Ingredient> filterBy(List<Ingredient> ingredients, TYPE t) {
		return ingredients.stream().filter(i -> i.getType().equalsIgnoreCase(t.name())).collect(Collectors.toList());
	}

	@ModelAttribute(name = "tacoOrder")
	public TacoOrder order() {
		return new TacoOrder();
	}

	@ModelAttribute(name = "taco")
	public Taco taco() {
		return new Taco();
	}

	// The main thing it does is return a String value of "design"
	@GetMapping("/showDesignForm")
	public String showDesignForm() {
		return "design";
	}

	/*
	 * The @ModelAttribute applied to the TacoOrder parameter indicates that it
	 * should use the TacoOrder object that was placed into the model via
	 * the @ModelAttribute-annotated order() method
	 */

	/*
	 * When the form is submitted, the fields in the form are bound to properties of
	 * a Taco object (whose class is shown in the next listing) that’s passed as a
	 * parameter
	 */

	@PostMapping("/getOrder")
	public String getOrder(@Valid Taco taco, BindingResult br, @ModelAttribute TacoOrder tacoOrder) {
		if(br.hasErrors()) {
			logger.error(br.getAllErrors().toString());
			return "design";
		}
		tacoOrder.addTaco(taco);
		logger.info("Processing taco: {}", taco);
		return "redirect:/orders/current";

	}
}
