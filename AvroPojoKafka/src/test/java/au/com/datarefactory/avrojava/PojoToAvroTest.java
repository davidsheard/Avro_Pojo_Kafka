package au.com.datarefactory.avrojava;

import java.io.IOException;
import org.apache.avro.generic.GenericRecord;
import org.junit.Test;
import au.gov.datarefactory.domain.Person;
import junit.framework.TestCase;

/**
* JUnit Test Case for PojoToAvro
* 
* @author  David Sheard
* @version 1.0
* @since   2019-04-22
*/
public class PojoToAvroTest extends TestCase {
	private PojoToAvro pojoToAvro;
	private Person person;
	
	@Test
	public void test() throws IOException {
		System.out.println("Running: test");
		GenericRecord avro = pojoToAvro.pojoToAvro(person);
		assert (avro.get("surname").toString().equals("Duck"));
		assert (avro.get("dob").toString().equals("1950"));
		assert (avro.get("givenName").toString().equals("Donald"));
		assert (avro.get("gender").toString().equals("Unknown"));
	}
	
	@Override  
	protected void setUp() throws IOException {
		System.out.println("Running: setUp");
		pojoToAvro  = new PojoToAvro();
		person = new Person();
		person.setSurname("Duck");
		person.setGivenName("Donald");
		person.setGender("Unknown");
		person.setDob("1950");
	}
	
	@Override
    protected void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        person = null;
        assertNull(person);
    }
}
