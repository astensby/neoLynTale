package no.stensby.javabin.neo.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@Configuration
@ComponentScan
@EnableNeo4jRepositories("no.stensby.javabin.neo.repositories")
public class ApplicationConfig extends Neo4jConfiguration {


    public ApplicationConfig(){
        setBasePackage("no.stensby.javabin.neo.domain");
    }

}
