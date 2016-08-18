package orderpicker.api;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 18:02
 */
public interface ApiService<T> {
    /**
     * //
     * @param id
     * @return //
     * @throws ApiServiceException
     */
    T get(int id) throws ApiServiceException;
}
