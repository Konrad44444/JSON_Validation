package com.remitly;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        JSONObject json = FileReader.readJSONFromFile("src\\main\\resources\\invalidFile.txt");

        System.out.println(json);


    }
}