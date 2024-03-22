package com.remitly;

import org.json.JSONObject;

import com.remitly.exceptions.IncorrectPathException;
import com.remitly.exceptions.InvalidJsonFileException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // String validJsonExample = "src\\main\\resources\\example.json";
        // String invalidJsonExample = "src\\main\\resources\\invalidFile.txt";
        // String notRoleJson = "src\\main\\resources\\notRoleJson.json";
        // String multipleStatements = "src\\main\\resources\\multipleStatements.json";

        try {

            String path = getPathFromUser();
            proccessFile(path);
        
        } catch (InvalidJsonFileException | IncorrectPathException e) {
            System.out.println(e.getMessage());
        }

    }

    private static String getPathFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type in path to the JSON file: (ex. src\\main\\resources\\example.json)");
        String path = scanner.nextLine();

        scanner.close();

        return path;
    }
    
    private static void proccessFile(String path) {
        JSONObject json = FileReader.readJSONFromFile(path);

        if (JsonVerifier.verifyFormat(json)) {
            System.out.println(JsonVerifier.verifyResourceField(json));
        } else {
            System.out.println("Format of JSON file is not a AWS::IAM::Role Policy");
        }
    }
}