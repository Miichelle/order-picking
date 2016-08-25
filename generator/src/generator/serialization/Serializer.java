package generator.serialization;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 16:20
 */

/***
 * Class for various types of conversions
 */
public interface Serializer<T> {
    /**
     * Converts an {@Object} to a {@String}
     * @return {@String}
     * @throws SerializationException
     */
    String serialize(T target) throws SerializationException;

    /**
     * Converts a {@String} to an {@Object}
     * @return {@Object}
     * @throws SerializationException
     */
    T deserialize(String s) throws SerializationException;
}
