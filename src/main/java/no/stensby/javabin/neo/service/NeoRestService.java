package no.stensby.javabin.neo.service;

import no.stensby.javabin.neo.configuration.RestApplicationConfig;
import no.stensby.javabin.neo.domain.Person;
import no.stensby.javabin.neo.repositories.PersonRepository;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
* Example class showcasing the use of the REST based Neo4j GraphDatabaseService - SpringRestGraphDatabase
* */
public class NeoRestService {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				RestApplicationConfig.class);

		PersonRepository personRepository = ctx.getBean(PersonRepository.class);
		
		long count = personRepository.count();
		System.out.println(count);
		
		personRepository.save(new Person("Aleksander", "Stensby"));
		
		count = personRepository.count();
		System.out.println(count);
		
		ctx.close();
		
		
		
	}

}
