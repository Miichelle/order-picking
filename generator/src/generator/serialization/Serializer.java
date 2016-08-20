package generator.serialization;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 16:20
 */
public interface Serializer<T> {
    /**
     * Converts an {@Object} to a {@String} from the conversion type
     * @return {@String}
     * @throws SerializationException
     */
    String serialize(T target) throws SerializationException;

    /**
     * Converts a conversion {@String} to an {@Object} wich requires a Class to convert to
     * @return {@Object}
     * @throws SerializationException
     */
    T deserialize(String s) throws SerializationException;
}
