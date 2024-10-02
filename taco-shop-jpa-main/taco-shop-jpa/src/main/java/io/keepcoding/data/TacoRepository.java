package io.keepcoding.data;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import io.keepcoding.model.Taco;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {

}
