package com.srm.portal;

import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class ReadDataFromJson extends CommonMethods {
    public String getProperty(String data) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(new FileReader("C:\\Users\\Jaswanth\\IdeaProjects\\SRM_STUDENT_PORTAL\\src\\main\\resources\\userData.json"));
        String user_data = (String) object.get(data);
        return user_data;
    }
}
