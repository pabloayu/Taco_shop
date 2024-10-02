package io.keepcoding.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import io.keepcoding.data.IngredientRepository;
import io.keepcoding.data.TacoRepository;
import io.keepcoding.model.Ingredient;
import io.keepcoding.model.Ingredient.Type;
import io.keepcoding.model.Order;
import io.keepcoding.model.Taco;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

	@Autowired
	private IngredientRepository ingredientRepo;
	
	@Autowired
	private TacoRepository tacoRepo;
	
	@GetMapping
	public String showDesignForm(Model model){
		prepareData(model);
		return "design";
	}

	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients.stream().filter(i -> i.getType().equals(type)).collect(Collectors.toList());
		
	}
	
	@ModelAttribute(name="tktn")
	public Taco taco() {
		return new Taco();
	}
	
	@ModelAttribute(name="order")
	public Order order() {
		return new Order();
	}
	
	
	@PostMapping
	public String processDesign(@Valid @ModelAttribute(name="tktn") Taco design, Errors errors, Model model, @ModelAttribute Order order) {
		
		if(errors.hasErrors()) {
			log.info(" no info add por user");
			prepareData(model);
			return "design";
		}
		
		tacoRepo.save(design);
		order.addDesign(design);
		
		log.info(design.toString());
		return "redirect:/orders/current";
	}
	
	private void prepareData(Model model) {
		List<Ingredient> ingredients = new ArrayList<>();
				
//				Arrays.asList(
//				new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
//			      new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
//			      new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
//			      new Ingredient("CARN", "Carnitas", Type.PROTEIN),
//			      new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
//			      new Ingredient("LETC", "Lettuce", Type.VEGGIES),
//			      new Ingredient("CHED", "Cheddar", Type.CHEESE),
//			      new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
//			      new Ingredient("SLSA", "Salsa", Type.SAUCE),
//			      new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
//				);
		
		ingredientRepo.findAll().forEach(i -> ingredients.add(i));;
		
		Type[] types = Ingredient.Type.values();
		
		for(Type type: types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
		
	}
}
