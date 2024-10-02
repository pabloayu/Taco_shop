package io.keepcoding.web.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.keepcoding.data.OrderRepository;
import io.keepcoding.model.Order;

@RestController
@RequestMapping(path="/api/orders", produces="application/json")
public class OrderTacoControllerApi {

	@Autowired
	private OrderRepository orderRepo;
	
	@GetMapping
	public Iterable<Order> findAll(){
		return orderRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Order orderById(@PathVariable("id") Long id) {
	Optional<Order> optOrder = orderRepo.findById(id);
	if (optOrder.isPresent()) {
	return optOrder.get();
	}
	return null;
	}

	@GetMapping("/byName/{name}")
	public Iterable<Order> findByName(@PathVariable("name") String name){
	return orderRepo.readOrderByDeliveryName(name);
	}

	@GetMapping("/byZip/{zip}")
	public Iterable<Order> findByZip(@PathVariable("zip") String zip){
	return orderRepo.readOrderByDeliveryZip(zip);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Order saveOrder(@RequestBody Order order) {
	Order saved = orderRepo.save(order);
	return saved;
	}


	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Order updateOrder(@RequestBody Order order) {
	Order updated = orderRepo.save(order);
	return updated;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOrder(@PathVariable("id") Long id) {
	orderRepo.deleteById(id);
	}
}