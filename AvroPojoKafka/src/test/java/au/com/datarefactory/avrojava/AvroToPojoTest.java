package au.com.datarefactory.avrojava;

import java.io.IOException;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import au.gov.datarefactory.domain.Person;
import junit.framework.TestCase;

/**
* JUnit Test Case for AvroToPojo
* 
* @author  David Sheard
* @version 1.0
* @since   2019-04-22
*/
public class AvroToPojoTest extends TestCase {
	
	private AvroToPojo avroToPojo = new AvroToPojo();
    private GenericRecord personAvroMessage;    
	
    @Test
	public void test() throws IOException {
		Person obj = avroToPojo.avroToPOJO(personAvroMessage, new Person());
		assert (obj.getGender().equals("Male"));
		assert (obj.getGivenName().equals("David"));
		assert (obj.getDob().equals("01/04/1990"));
	}
	
	@Override  
	protected void setUp() throws IOException {
		System.out.println("Running: setUp");
		personAvroMessage  = createPersonAvroMessageForTest();
	}	
	
	@Override
    protected void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        personAvroMessage = null;
        assertNull(personAvroMessage);
    }
	
	private GenericRecord createPersonAvroMessageForTest() throws IOException {
		Schema mainSchema = new Schema.Parser()
				.parse(new ClassPathResource("AvroFiles/PersonEntity.avsc").getInputStream());
		GenericRecord personAvroMessage = new GenericData.Record(mainSchema);
		personAvroMessage.put("surname", "Sheard");
		personAvroMessage.put("givenName", "David");
		personAvroMessage.put("dob", "01/04/1990"); // I wish :)
		personAvroMessage.put("gender", "Male");
		return personAvroMessage;
	}
}
