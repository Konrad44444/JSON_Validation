package com.remitly;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class FileReader {
    public static JSONObject readJSONFromFile(String path) {
        File f = new File(path);

        String jsonTxt = "";

        if (f.exists()) {

            try {

                InputStream is = new FileInputStream(path);
                jsonTxt = IOUtils.toString(is, "UTF-8");

            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }

        } else {
            // TODO: handle custom exceptions
            throw new RuntimeException("Bad path exception");
        }
        
        try {
            JSONObject json = new JSONObject(jsonTxt);

            return json;
        } catch (JSONException e) {
            // TODO: handle custom exceptions
            throw new RuntimeException("Bad file exception");
        }
    }
}
