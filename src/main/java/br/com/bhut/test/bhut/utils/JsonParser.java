package br.com.bhut.test.bhut.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParser {

    public JSONArray parse(String json) {
        String jsonData = "{\"cars\":" + json + "}";
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray cars = jsonObject.getJSONArray("cars");

        return cars;
    }

}
