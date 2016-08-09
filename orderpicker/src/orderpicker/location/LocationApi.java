package orderpicker.location;

import be.kdg.se3.proxy.LocationServiceProxy;
import com.google.gson.Gson;
import orderpicker.models.Location;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 18:06
 */
public class LocationApi implements LocationService {
    private LocationServiceProxy service;
    private final Logger logger = Logger.getLogger(LocationApi.class);


    @Override
    public void Initialize() {
        this.service = new LocationServiceProxy();
    }

    @Override
    public Location getLocation(String productId) throws LocationServiceException {
        String json = getFromService(productId);
        return parseJson(json);
    }

    private Location parseJson(String json) throws LocationServiceException{
        Gson gson = new Gson();
        return gson.fromJson(json, Location.class);
    }

    @Override
    public String getFromService(String productId) throws LocationServiceException {
        try {
            return service.get("www.services4se3.com/locationservice/productID/" + productId);
        } catch (IOException e) {
            throw new LocationServiceException("Error connecting with ship service",e);
        }
    }
}
