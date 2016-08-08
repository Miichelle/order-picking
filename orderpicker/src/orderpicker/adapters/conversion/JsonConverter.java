package orderpicker.adapters.conversion;

import com.google.gson.Gson;

/**
 * Michelle Beckers
 * Datum: 2-8-2016
 * Time: 15:41
 */

//TODO is deze nodig??
public class JsonConverter {
    public static <T> T fromJson(String json, Class<T> classOfT){
        return new Gson().fromJson(json, classOfT);
    }
}
