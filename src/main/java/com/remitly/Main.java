package com.remitly;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        String validJsonExample = "src\\main\\resources\\example.json";
        String invalidJsonExample = "src\\main\\resources\\invalidFile.txt";
        String notRoleJson = "src\\main\\resources\\notRoleJson.json";
        String multipleStatements = "src\\main\\resources\\multipleStatements.json";

        JSONObject json = FileReader.readJSONFromFile(notRoleJson);

        if (JsonVerifier.verifyFormat(json)) {
            System.out.println( JsonVerifier.verifyResourceField(json));
        } else {
            System.out.println("Not valid JSON file");
        }


    }
}