package com.remitly;

import org.json.JSONObject;

import com.remitly.exceptions.IncorrectPathException;
import com.remitly.exceptions.InvalidJsonFileException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {

            String path = getPathFromUser();
            proccessFile(path);

        } catch (InvalidJsonFileException | IncorrectPathException e) {
            System.out.println(e.getMessage());
        }

    }

    private static String getPathFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Type in path to the JSON file: (ex. src\\test\\resources\\example.json)");
        String path = scanner.nextLine();

        scanner.close();

        return path;
    }

    private static void proccessFile(String path) {
        JSONObject json = FileReader.readJSONFromFile(path);

        if (JsonVerifier.verifyFormat(json)) {

            if (JsonVerifier.verifyResourceField(json)) {
                System.out.println("True - there is no single asterisk in Resource field");
            } else {
                System.out.println("False - there is single asterisk in Resource field");
            }

        } else {
            System.out.println("Format of JSON file is not a AWS::IAM::Role Policy");
        }
    }
}