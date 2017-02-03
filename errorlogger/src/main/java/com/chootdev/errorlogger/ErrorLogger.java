package com.chootdev.errorlogger;

import android.content.Context;

import com.chootdev.errorlogger.database.DatabaseManager;
import com.chootdev.errorlogger.model.LoggerModel;
import com.chootdev.errorlogger.repo.ErrorRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Choota on 2/3/17.
 */

public class ErrorLogger {

    private static ErrorLogger logger;
    private static Context loggerContext;
    private static ErrorRepo errorRepo;

    public static void init(Context context){
        DatabaseManager.init(context);
    }

    public static ErrorLogger with(Context context){
        loggerContext = context.getApplicationContext();
        errorRepo = new ErrorRepo();

        if(logger == null)
            logger = new ErrorLogger();

        return logger;
    }

    // add record to error manager
    public static boolean add(LoggerModel model){
        int i = errorRepo.create(model);
        return i != 0 ? true:false;
    }

    // get a single log
    public static LoggerModel getLogRecord(int id){
        return errorRepo.findById(id);
    }

    // get all records
    public static List<LoggerModel> getAllRecords(){
        return (List<LoggerModel>) errorRepo.findAll();
    }

    // clear all records
    public static boolean clearLogger(){
        return errorRepo.truncate(LoggerModel.class);
    }

    // get mostrecent records, can request order
    public static List<LoggerModel> getMostRecent(int requiredAmount, boolean isMostRecentFirst){
        List<LoggerModel> loggerModels = (List<LoggerModel>) errorRepo.findAll();
        if(loggerModels!=null && requiredAmount>=loggerModels.size()){
            if(!isMostRecentFirst)
                return loggerModels;
            else {
                List<LoggerModel> temp = new ArrayList<>();
                for(int i = loggerModels.size()-1; i==0; i--){
                    temp.add(loggerModels.get(i));
                }

                return temp;
            }
        } else {
            if(!isMostRecentFirst){
                List<LoggerModel> temp = new ArrayList<>();
                for(int i = 0; i<requiredAmount; i++){
                    temp.add(loggerModels.get(i));
                }

                return temp;
            } else {
                List<LoggerModel> temp = new ArrayList<>();
                for(int i=0; i<requiredAmount; i++){
                    temp.add(loggerModels.get(loggerModels.size()-(i+1)));
                }

                return temp;
            }

        }
    }
}
