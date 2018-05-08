## Release

	mvn clean install
	mvn release:clean
	mvn release:prepare
	mvn release:perform
	
	./releaseContainer
	docker login
	docker push snscaimito/animals
	
	./deployProduction

## Profiles

### Profile "test"
- Expose all actuator endpoints
- Enable DEBUG logging for net.caimito

### Profile "localmongo"
- Use MongoDB on localhost 
