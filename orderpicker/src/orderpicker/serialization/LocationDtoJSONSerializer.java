package orderpicker.serialization;

import com.google.gson.Gson;
import orderpicker.models.dto.LocationDto;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 19:31
 */
public class LocationDtoJSONSerializer implements Serializer<LocationDto> {
    private Gson gson;

    public LocationDtoJSONSerializer() {
        this.gson = new Gson();
    }

    @Override
    public String serialize(LocationDto dto) throws SerializationException {
        return this.gson.toJson(dto);
    }

    @Override
    public LocationDto deserialize(String json) throws SerializationException {
        return this.gson.fromJson(json, LocationDto.class);
    }
}
