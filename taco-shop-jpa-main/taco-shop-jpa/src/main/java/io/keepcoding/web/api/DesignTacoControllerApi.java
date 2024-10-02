package io.keepcoding.web.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.keepcoding.data.TacoRepository;
import io.keepcoding.model.Taco;

@RestController
@RequestMapping(path="/api/tacosorder", produces="application/json")
public class DesignTacoControllerApi {
	
	@Autowired
	private TacoRepository tacoRepo;
	
//	@GetMapping("/{id}")
//	public Taco tacoById(@PathVariable("id") Long id) {
//		Optional<Taco> optTaco = tacoRepo.findById(id);
//		if(optTaco.isPresent()) {
//			return optTaco.get();
//		}
//		return null;
//	}

	@GetMapping("/{id}")
	public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
		Optional<Taco> optTaco = tacoRepo.findById(id);
		if(optTaco.isPresent()) {
			return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Taco createTaco(@RequestBody Taco taco) {
		Taco savedTaco = tacoRepo.save(taco);
		return savedTaco;
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Taco updateTaco(@RequestBody Taco taco){
		
		Taco updated = tacoRepo.save(taco);
		return updated;
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTaco(@RequestBody Taco taco){
		tacoRepo.delete(taco);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTacoById(@PathVariable("id") Long id){
	    tacoRepo.deleteById(id);
	}

	@GetMapping
	public Iterable<Taco> findAll(){
		return tacoRepo.findAll();
	}
	
	@GetMapping("/paged")
	public Iterable<Taco> findAllRecent(){
		PageRequest pageRequest = PageRequest.of(0, 3);
		return tacoRepo.findAll(pageRequest);
	}
	
	@GetMapping("/paged/{num_page}")
    public Iterable<Taco> findAllByPage(@PathVariable("num_page") int num_page){
        PageRequest pageRequest = PageRequest.of(num_page, 3);
        return tacoRepo.findAll(pageRequest);
    }
	
	@GetMapping("/recent/{num_page}")
    public Iterable<Taco> findAllRecent(@PathVariable("num_page") int num_page){
        PageRequest pageRequest = PageRequest.of(num_page, 3, Sort.by("createdAt").descending());
        return tacoRepo.findAll(pageRequest);
    }
	
	
	
}
