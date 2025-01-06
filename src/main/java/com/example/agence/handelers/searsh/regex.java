package com.example.agence.handelers.searsh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.TextField;

public class regex {
    private static final String NUM_REGEX = "^[1-9]$";
    private static final String CITY_REGEX = "^(fes|fés|fès|rabat|casablanca|marrakech|tanger|chefchaouen)$";

    // Email
    public static Boolean validPassenger(TextField pass) {
        Pattern pattern = Pattern.compile(NUM_REGEX);

        Matcher matcher = pattern.matcher(pass.getText().trim());
        return matcher.matches();
    }

    public static Boolean validcity(TextField city) {
        Pattern pattern = Pattern.compile(CITY_REGEX);

        Matcher matcher = pattern.matcher(city.getText().trim().toLowerCase());
        return matcher.matches();
    }
}
