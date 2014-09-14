package no.stensby.javabin.neo.service;

import no.stensby.javabin.neo.configuration.EmbeddedApplicationConfig;
import no.stensby.javabin.neo.domain.Person;
import no.stensby.javabin.neo.repositories.PersonRepository;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
* Example class showcasing the use of an embedded Neo4j GraphDatabaseService
* */
public class NeoEmbeddedService {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				EmbeddedApplicationConfig.class);

		PersonRepository personRepository = ctx.getBean(PersonRepository.class);

		long count = personRepository.count();
		System.out.println(count);

		personRepository.save(new Person("Aleksander", "Stensby"));

		count = personRepository.count();
		System.out.println(count);

		ctx.close();
	}
}
