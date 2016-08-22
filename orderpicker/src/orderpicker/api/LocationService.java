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
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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

    private List<Integer> unproccesedOrders;

    private String errorString = "{\"error\":\"Unknown productID\",\"description\":\"Wrong productID format (< 1000000)\"}";


    public LocationService(long cacheInterval,long retryGetInterval) {
        this.baseUrl = "www.services4se3.com/locationservice";
        this.locationCache = new LocationCache(cacheInterval);
        this.locationDtoSerializer = new JSONSerializer<>(LocationDto.class);
        this.service = new LocationServiceProxy();
        this.unproccesedOrders =  new ArrayList<>();

        retry(retryGetInterval);

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

            if(!errorString.equals(json)){
                dto = this.locationDtoSerializer.deserialize(json);

                dto.setProductId(id);

                location = Mapper.map(dto);

                this.locationCache.cache(id, location);

                unproccesedOrders.remove(id);


            }else{
                if(!unproccesedOrders.contains(id)){
                    unproccesedOrders.add(id);
                }
            }

        } catch (IOException e) {
            throw new ApiServiceException("Error while connecting with location service", e);
        } catch (SerializationException e) {
            logger.error("An error has occured when serializing a json string in LocationService");
        }

        return location;
    }

    public void retry(long interval){
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    for (int i = 0; i < unproccesedOrders.size(); i++) {
                        try {
                            get(i);
                        } catch (ApiServiceException e) {
                            logger.error("Something went wrong while retrying to get the location info ");
                        }
                    }
                }
            };

            timer.schedule(task, interval);
        }
    }

