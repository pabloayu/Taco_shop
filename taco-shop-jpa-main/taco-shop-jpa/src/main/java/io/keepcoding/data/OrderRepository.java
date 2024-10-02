package io.keepcoding.data;

import org.springframework.data.repository.CrudRepository;

import io.keepcoding.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
	Iterable<Order> readOrderByDeliveryName(String name);

	Iterable<Order> readOrderByDeliveryZip(String zip);

}
