package no.stensby.javabin.neo.repositories;

import no.stensby.javabin.neo.domain.Person;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface PersonRepository extends GraphRepository<Person> {

	Person findByFirstName(String firstName);

}
