package au.com.datarefactory.avrojava;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumWriter;

/**
* Convert a POJO to an Avro Object
* 
* @author  David Sheard
* @version 1.0
* @since   2019-04-22
*/
public class PojoToAvro {

	public <T> GenericRecord pojoToAvro(T obj) throws IOException {		 
	
		Schema schema = ReflectData.get().getSchema(obj.getClass());
		 
        ReflectDatumWriter<T> reflectDatumWriter = new ReflectDatumWriter<>(schema);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
 
        BinaryEncoder binaryEncoder = EncoderFactory.get().binaryEncoder(outputStream, null);
        reflectDatumWriter.write(obj, binaryEncoder);
        binaryEncoder.flush();
 
        GenericDatumReader<GenericRecord> genericDatumReader = new GenericDatumReader<>(schema);
        BinaryDecoder binaryDecoder = DecoderFactory.get().binaryDecoder(outputStream.toByteArray(), null);
 
        GenericRecord record = genericDatumReader.read(null, binaryDecoder);
	    return record;

	}
}
