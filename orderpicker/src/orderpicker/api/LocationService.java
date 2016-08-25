package orderpicker.api;

import be.kdg.se3.proxy.LocationServiceProxy;
import orderpicker.cache.Cache;
import orderpicker.cache.LocationCache;
import orderpicker.models.domain.Location;
import orderpicker.models.dto.LocationDto;
import orderpicker.models.mapping.Mapper;
import orderpicker.serialization.JSONSerializer;
import orderpicker.serialization.SerializationException;
import orderpicker.serialization.Serializer;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 18:06
 */
public class LocationService implements ApiService<Location> {
    private final Logger logger = Logger.getLogger(LocationService.class);

    private String baseUrl;
    private Cache<Integer, Location> locationCache;
    private Serializer<LocationDto> locationDtoSerializer;
    private LocationServiceProxy service;

    public LocationService(long cacheInterval) {
        this.baseUrl = "www.services4se3.com/locationservice";
        this.locationCache = new LocationCache(cacheInterval);
        this.locationDtoSerializer = new JSONSerializer<>(LocationDto.class);
        this.service = new LocationServiceProxy();
    }

    @Override
    public Location get(int id) throws ApiServiceException {
        if (this.locationCache.isCached(id)) {
            return this.locationCache.get(id);
        }

        String json = null;
        LocationDto dto = null;
        Location location = null;

        String url = String.format("%s/productID/%d", this.baseUrl, id);

        try {
            json = this.service.get(url);

            String errorString = "{\"error\":\"Unknown productID\",\"description\":\"Wrong productID format (< 1000000)\"}";
            if(!errorString.equals(json)) {
                dto = this.locationDtoSerializer.deserialize(json);

                dto.setProductId(id);

                location = Mapper.map(dto);

                this.locationCache.cache(id, location);
            }else{
                throw new ApiServiceException("location not found");
            }

        } catch (IOException e) {
            throw new ApiServiceException("Error while connecting with location service", e);
        } catch (SerializationException e) {
            logger.error("An error has occured when serializing a json string in LocationService");
        }

        return location;
    }
}

