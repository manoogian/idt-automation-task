package com.automation.ui.service;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class Preconditions {

    public static UserLoginDetails createDefaultUser() {
        try {

            JSONObject json = readTestUserData();

            URL url = new URL("https://automationexercise.com/api/createAccount");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            // Save User email and password for returning from this function
            String userEmail = UUID.randomUUID() + json.getString("email");
            String userPassword = json.getString("password");

            // Prepare request parameters from JSON data
            String params = "name=" + json.getString("name") +
                    "&email=" + userEmail +
                    "&password=" + userPassword +
                    "&title=" + json.getString("title") +
                    "&birth_date=" + json.getString("birth_date") +
                    "&birth_month=" + json.getString("birth_month") +
                    "&birth_year=" + json.getString("birth_year") +
                    "&firstname=" + json.getString("firstname") +
                    "&lastname=" + json.getString("lastname") +
                    "&company=" + json.getString("company") +
                    "&address1=" + json.getString("address1") +
                    "&address2=" + json.getString("address2") +
                    "&country=" + json.getString("country") +
                    "&zipcode=" + json.getString("zipcode") +
                    "&state=" + json.getString("state") +
                    "&city=" + json.getString("city") +
                    "&mobile_number=" + json.getString("mobile_number");

            // Write request parameters to request body
            OutputStream os = connection.getOutputStream();
            os.write(params.getBytes(StandardCharsets.UTF_8));
            os.flush();
            os.close();

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("User created successfully!");
            } else {
                System.out.println("Failed to create user.");
            }
            return UserLoginDetails.builder()
                    .email(userEmail)
                    .password(userPassword)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("Precondition FAILURE: User Creation Failed!", e);
        }
    }

    private static JSONObject readTestUserData() throws IOException {
        String jsonFilePath = "src/test/resources/data/users/user_data.json";
        BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath));
        StringBuilder jsonStringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonStringBuilder.append(line);
        }
        reader.close();

        return new JSONObject(jsonStringBuilder.toString());
    }
}
