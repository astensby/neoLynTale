package no.stensby.javabin.neo.configuration;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;

@Configuration
public class RestApplicationConfig extends ApplicationConfig {

	@Bean
	GraphDatabaseService graphDatabaseService() {

		return new SpringRestGraphDatabase("http://localhost:7474/db/data");

	}
}
