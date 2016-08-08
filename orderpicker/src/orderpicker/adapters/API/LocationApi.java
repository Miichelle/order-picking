package orderpicker.adapters.API;

import be.kdg.se3.proxy.LocationServiceProxy;
import orderpicker.adapters.conversion.JsonConverter;
import orderpicker.models.Location;
import orderpicker.exceptions.LocationServiceException;
import orderpicker.interfaces.LocationService;

import java.io.IOException;

/**
 * Michelle Beckers
 * Datum: 3-8-2016
 * Time: 16:21
 */
public class LocationApi implements LocationService {
    private LocationServiceProxy service;
    private JsonConverter jsonConverter;

    public LocationApi() {
        this.service = new LocationServiceProxy();
        jsonConverter = new JsonConverter();
    }

    @Override
    public Location getLocation(String storageRoom, int hallway, int rack) throws LocationServiceException {
        String json = getFromService(storageRoom,hallway,rack);
        Location location = jsonConverter.fromJson(json,Location.class);
        return location;
    }

    protected String getFromService(String loc1,int loc2, int loc3) throws LocationServiceException {
        try {
            return service.get("string"+loc1+loc2+loc3);
        } catch (IOException e) {
            throw new LocationServiceException("Error connecting with location service",e);
        }
    }
}
