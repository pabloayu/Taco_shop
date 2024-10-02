package io.keepcoding.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
	@Id
	private  String id;
	private  String name;
	@Enumerated(EnumType.STRING)
	private  Type type;
	
	public static enum Type{
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}	
} 
