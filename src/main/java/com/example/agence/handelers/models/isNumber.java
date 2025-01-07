package com.example.agence.handelers.models;

public class isNumber {
    public static boolean isNumber(String str) {
        try {
            // Try parsing as a double (supports integers and floating-point numbers)
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
