package com.remitly;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        String validJsonExample = "src\\main\\resources\\example.json";
        String invalidJsonExample = "src\\main\\resources\\invalidFile.txt";
        String notRoleJson = "src\\main\\resources\\notRoleJson.json";

        JSONObject json = FileReader.readJSONFromFile(notRoleJson);

        System.out.println(json);

        System.out.println(JsonVerifier.verifyFormat(json));


    }
}