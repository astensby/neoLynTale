package no.stensby.javabin.neo.repositories;

import no.stensby.javabin.neo.configuration.TestApplicationConfig;
import no.stensby.javabin.neo.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestApplicationConfig.class})
public class PersonRepositoryTest {

    @Autowired
    PersonRepository repository;

    @Autowired
    protected Neo4jTemplate template;

    @Test
    public void savesPersonCorrectly() {
        Person p = new Person("Aleksander", "Stensby");
        Person result = repository.save(p);

        assertNotNull("persisted person has been assigned a node ID", result.getNodeId());
        assertEquals("person name matches persisted person name",
                p.getFirstName(), result.getFirstName());

        Person retrievedP = repository.findOne(result.getNodeId());

        assertEquals("retrieved person name matches persisted person name",
                result.getFirstName(), retrievedP.getFirstName());

    }

}
