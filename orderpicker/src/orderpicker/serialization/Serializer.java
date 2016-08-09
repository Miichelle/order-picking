package orderpicker.serialization;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 16:20
 */
public interface Serializer {
    /**
     * Returns the name of the orderpicker.serialization (e.g. XML)
     * @return
     */
    String getType();

    /**
     * Converts an {@Object} to a {@String} from the conversion type
     * @return {@String}
     * @throws SerializationException
     */
    String serialize(Object o) throws SerializationException;

    /**
     * Converts a conversion {@String} to an {@Object} wich requires a Class to convert to
     * @return {@Object}
     * @throws SerializationException
     */
    Object deserialize(String s) throws SerializationException;
}
