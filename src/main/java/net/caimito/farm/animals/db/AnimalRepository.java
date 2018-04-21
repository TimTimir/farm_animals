package net.caimito.farm.animals.db;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimalRepository extends MongoRepository<AnimalEntity, String> {

	public AnimalEntity findByEid(String eid) ;
	
}
