package no.stensby.javabin.neo.repositories;

import static org.junit.Assert.assertEquals;
import no.stensby.javabin.neo.configuration.TestApplicationConfig;
import no.stensby.javabin.neo.domain.Person;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestApplicationConfig.class })
public class PersonRepositoryTest {

	@Autowired
	PersonRepository repository;

	@Autowired
	protected Neo4jTemplate template;

	@Test
	public void savesPersonCorrectly() {
		Person p = new Person("Aleksander", "Stensby");
		Person result = repository.save(p);

		Assert.assertNotNull(result.getNodeId());

		Person retrievedP = repository.findOne(result.getNodeId());

		assertEquals("retrieved person name matches persisted person name",
				"Aleksander", retrievedP.getFirstName());
		assertEquals("retrieved person name matches persisted person name",
				result.getFirstName(), retrievedP.getFirstName());

	}

}
