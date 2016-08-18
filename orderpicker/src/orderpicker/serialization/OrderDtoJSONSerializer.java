package orderpicker.serialization;

import com.google.gson.Gson;
import orderpicker.models.dto.OrderDto;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 18:41
 */
public class OrderDtoJSONSerializer implements Serializer<OrderDto> {
    private Gson gson;

    public OrderDtoJSONSerializer() {
        this.gson = new Gson();
    }

    @Override
    public String serialize(OrderDto dto) throws SerializationException {
        return this.gson.toJson(dto);
    }

    @Override
    public OrderDto deserialize(String json) throws SerializationException {
        return this.gson.fromJson(json, OrderDto.class);
    }
}
