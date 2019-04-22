package au.com.datarefactory.avrojava;

import org.apache.avro.generic.GenericRecord;
import org.springframework.beans.PropertyAccessorFactory;

/**
* Convert an Avro Object to a POJO
* 
* @author  David Sheard
* @version 1.0
* @since   2019-04-22
*/
public class AvroToPojo {
	
	public <T> T avroToPOJO(GenericRecord avroRecord, T obj) {
		avroRecord.getSchema().getFields().forEach(f -> {
			PropertyAccessorFactory.forDirectFieldAccess(obj).setPropertyValue(f.name(),
					avroRecord.get(f.name()) == null ? avroRecord.get(f.name()) : avroRecord.get(f.name()).toString());
		});
		
		return obj;
	}

}
