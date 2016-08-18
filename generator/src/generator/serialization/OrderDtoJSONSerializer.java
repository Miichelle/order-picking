package generator.serialization;

import com.google.gson.Gson;
import generator.models.dto.OrderDto;

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
    public String serialize(OrderDto order) throws SerializationException {
        return this.gson.toJson(order);
    }

    @Override
    public OrderDto deserialize(String s) throws SerializationException {
        return this.gson.fromJson(s, OrderDto.class);
    }
}
