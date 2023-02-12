package com.example.heavenmeeting.recylcer_adapter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Meeting {
    private String name;
    private String description;
    private String date;
    private List<String> attendees;


    public Meeting(String name, String description, String date, List<String> attendees) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.attendees = attendees;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        String formatPattern = "dd MMMM yy";
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date parsedDate = simpleDateFormat.parse(this.date, new ParsePosition(1));
        SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
        return formatter.format(parsedDate);
    }

    public String getDescription() {
        return description;
    }

    public List<String> getAttendees() {
        return attendees;
    }

    public static Meeting ExractMeeting(JsonObject obj) {
        String name = obj.get("author").getAsString();
        String date = obj.get("dateAdded").getAsString();
        String description = obj.get("content").getAsString();
        List<String> attendees = new ArrayList();
        JsonArray tags = obj.get("tags").getAsJsonArray();
        for(int i = 0; i < tags.size() && i < 3; i++) {
            attendees.add(tags.get(i).getAsString().toUpperCase().substring(0,1));
        }
        return new  Meeting(name, description, date, attendees);
    }
}
