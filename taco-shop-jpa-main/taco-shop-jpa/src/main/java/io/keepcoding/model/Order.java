package io.keepcoding.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

//import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
@Entity
@Table(name="Taco_Order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date placedAt;
	
	@NotBlank(message = "Name is required")
	private String deliveryName;

	private String deliveryStreet;

	private String deliveryCity;

	private String deliveryState;

	private String deliveryZip;
	@CreditCardNumber(message = "Invalid Credit card number ")
	private String ccNumber;
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
	private String ccExpiration;
	@Digits(integer=3, fraction=0, message = "Invalid CVV")
	private String ccCVV;
	@ManyToMany(targetEntity = Taco.class)
	private List<Taco> tacos = new ArrayList<>();
	
	public void addDesign(Taco design) {
		tacos.add(design);
		}
	
	@PrePersist
	void placedAt() {
		placedAt = new Date();
	}
}

