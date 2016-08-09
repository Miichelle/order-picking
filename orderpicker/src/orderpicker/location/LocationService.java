package orderpicker.location;

import orderpicker.models.Location;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 18:02
 */
public interface LocationService {

    /***
     * Initializes the Service
     */
    void Initialize();

    /**
     * A service which returns information about a given ship
     * @param productId
     * @return The location of the product
     * @throws LocationServiceException
     */
    Location getLocation(String productId) throws LocationServiceException;

    String getFromService(String productId) throws LocationServiceException;

}
