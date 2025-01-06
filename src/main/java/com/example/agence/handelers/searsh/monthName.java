package com.example.agence.handelers.searsh;

import java.util.HashMap;
import java.util.Map;

public class monthName {
    public static String monthName(int monthNumber) {
        Map<Integer, String> monthMap = new HashMap<>();
        monthMap.put(1, "January");
        monthMap.put(2, "February");
        monthMap.put(3, "March");
        monthMap.put(4, "April");
        monthMap.put(5, "May");
        monthMap.put(6, "June");
        monthMap.put(7, "July");
        monthMap.put(8, "August");
        monthMap.put(9, "September");
        monthMap.put(10, "October");
        monthMap.put(11, "November");
        monthMap.put(12, "December");

        String monthName = monthMap.get(monthNumber);
        return monthName;

    }
}
