package no.stensby.javabin.neo.configuration;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddedApplicationConfig extends ApplicationConfig {

	@Bean
	GraphDatabaseService graphDatabaseService() {

		return new GraphDatabaseFactory().newEmbeddedDatabase("tmp/neo4j");

	}

}
