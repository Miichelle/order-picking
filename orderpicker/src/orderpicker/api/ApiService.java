package orderpicker.api;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 18:02
 */

/**
 * Defines a service which supplies data about the locations of order items
 */
public interface ApiService<T> {
    /**
     * Gets the location info from Api
     * @param id
     * @throws ApiServiceException
     */
    T get(int id) throws ApiServiceException;
}
