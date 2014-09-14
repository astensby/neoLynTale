package no.stensby.javabin.neo.configuration;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.test.TestGraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TestApplicationConfig extends ApplicationConfig {

	@Bean(destroyMethod = "shutdown")
	@Scope(SCOPE_PROTOTYPE)
	public GraphDatabaseService graphDatabaseService() {

		return new TestGraphDatabaseFactory().newImpermanentDatabase();
	}

}
