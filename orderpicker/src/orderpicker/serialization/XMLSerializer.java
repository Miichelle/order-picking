package orderpicker.serialization;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.InputSource;

import java.io.*;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 17:28
 */
public class XMLSerializer implements Serializer {
    private final String CONVERTOR_TYPE="XMLSerializer";

    @Override
    public String getType() {return CONVERTOR_TYPE; }

    @Override
    public String serialize(Object o) throws SerializationException {
       Writer writer = new StringWriter();
        try {
            Mapping mapping = new Mapping();
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mapping/mapping.xml");
            Reader reader = new InputStreamReader(inputStream,"UTF-8");
            InputSource inputSource = new InputSource(reader);
            mapping.loadMapping(inputSource);
            Marshaller marshaller = new Marshaller();
            marshaller.setMapping(mapping);
            marshaller.setWriter(writer);
            marshaller.marshal(o);
        } catch (MarshalException | ValidationException | MappingException | IOException e) {
            String message = "Error during conversion from object to XMLSerializer string";
            throw new SerializationException(message, e);
        }
        return writer.toString();
    }

    @Override
    public Object deserialize(String s) throws SerializationException {
        Object o;
        BufferedReader reader = new BufferedReader(new StringReader(s));
        org.exolab.castor.xml.Unmarshaller unmarshaller = new org.exolab.castor.xml.Unmarshaller();
        try {
            o = unmarshaller.unmarshal(reader);
        } catch (MarshalException | ValidationException e) {
            String message = "Error during conversion from XMLSerializer string to object";
            throw new SerializationException(message, e);
        }
        return o;
    }
}
