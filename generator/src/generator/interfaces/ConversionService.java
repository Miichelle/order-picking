package generator.interfaces;

import generator.exceptions.ConversionException;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 16:20
 */
public interface ConversionService {
    /***
     * Returns the name of the Conversion Service (e.g. XML)
     * @return
     */
    String getType();

    /***
     * Converts an {@Object} to a {@String} from the conversion type
     * @return {@String}
     * @throws ConversionException
     */
    String convertTo(Object o) throws ConversionException;

    /***
     * Converts a conversion {@String} to an {@Object} wich requires a Class to convert to
     * @return {@Object}
     * @throws ConversionException
     */
    Object convertFrom(String s) throws ConversionException;
}
