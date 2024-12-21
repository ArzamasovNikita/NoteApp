package com.example.noteapp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HolidayService {
    public boolean isHoliday(String date) {
        try {
            String apiUrl = "https://isdayoff.ru/api/getdata?date=" + date;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            Scanner scanner = new Scanner(connection.getInputStream());
            String response = scanner.nextLine();
            scanner.close();

            return "1".equals(response); // 1 - выходной, 0 - рабочий
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}