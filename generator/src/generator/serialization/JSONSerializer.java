package generator.serialization;

import com.google.gson.Gson;

/**
 * Michelle Beckers
 * Datum: 18-8-2016
 * Time: 18:41
 */
public class JSONSerializer<T> implements Serializer<T> {
    private final Class<?> type;
    private Gson gson;

    public JSONSerializer(Class<?> type) {
        this.gson = new Gson();
        this.type = type;
    }

    @Override
    public String serialize(T dto) throws SerializationException {
        return this.gson.toJson(dto);
    }

    @Override
    public T deserialize(String json) throws SerializationException {
        return this.gson.fromJson(json, (Class<T>) this.type);
    }
}
