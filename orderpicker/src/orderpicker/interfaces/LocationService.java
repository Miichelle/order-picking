package orderpicker.interfaces;

import orderpicker.models.Location;
import orderpicker.exceptions.LocationServiceException;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 18:02
 */
public interface LocationService {
    /**
     * A service which returns information about a given ship
     * @param storageRoom, hallway, rack
     * @return The location for the order
     * @throws LocationServiceException
     */
    Location getLocation(String storageRoom, int hallway, int rack) throws LocationServiceException;
}
