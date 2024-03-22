package com.remitly;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.remitly.exceptions.IncorrectPathException;

public class FileReader {
    public static JSONObject readJSONFromFile(String path) {

        String jsonTxt = "";

        try {

            InputStream is = new FileInputStream(path);
            jsonTxt = IOUtils.toString(is, "UTF-8");

        } catch (IOException e) {
            throw new IncorrectPathException("Check path", e);
        }
        
        try {
            JSONObject json = new JSONObject(jsonTxt);

            return json;
        } catch (JSONException e) {
            // TODO: handle custom exceptions
            throw new RuntimeException("Bad JSON exception");
        }
    }
}
