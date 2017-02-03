package com.chootdev.errorlogger.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by Choota on 2/3/17.
 */

@DatabaseTable
public class LoggerModel {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String title;

    @DatabaseField
    private String message;

    @DatabaseField
    private String date;

    @DatabaseField
    private String activityName;

    public LoggerModel() {
        setDefaultValues();
    }

    public LoggerModel(String title, String message) {
        this.title = title;
        this.message = message;

        setDefaultValues();
    }

    public LoggerModel(String title, String message, String date) {
        this.title = title;
        this.message = message;
        this.date = date;

        setDefaultValues();
    }

    public LoggerModel(String title, String message, String date, String activityName) {
        this.title = title;
        this.message = message;
        this.date = date;
        this.activityName = activityName;

        setDefaultValues();
    }

    private void setDefaultValues() {
        this.title = this.title != null ? this.title : "";
        this.message = this.message != null ? this.message : "";
        this.date = this.date != null ? this.date : new Date().toString();
        this.activityName = this.activityName != null ? this.activityName : "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
