package br.com.bhut.test.bhut.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParser {

    public JSONArray parseArray(String json) {
        String jsonData = "{\"array\":" + json + "}";
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray array = jsonObject.getJSONArray("array");

        return array;
    }

}
