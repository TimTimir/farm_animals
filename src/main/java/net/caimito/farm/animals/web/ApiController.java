package net.caimito.farm.animals.web;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import net.caimito.farm.animals.Animal;
import net.caimito.farm.animals.db.AnimalEntity;
import net.caimito.farm.animals.db.AnimalRepository;

@RestController
@RequestMapping("/api/animals")
public class ApiController {
	private static final Logger logger = LoggerFactory.getLogger(ApiController.class) ;
	
	@Autowired
	private AnimalRepository inventory ;

	@PutMapping(consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
		logger.debug("animal was {}", animal);
		if (animal == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;
		else {
			AnimalEntity entity = AnimalEntity.instanceFrom(animal) ;
			inventory.save(entity);
			String id = entity.getId() ;

			URI location = ServletUriComponentsBuilder
					.fromCurrentContextPath().path("/api/animals/{id}")
					.buildAndExpand(id).toUri();

			return ResponseEntity.created(location).build();
		}
	}
	
	@DeleteMapping
	public void deleteAnimals() {
		inventory.deleteAll() ;
	}
}
