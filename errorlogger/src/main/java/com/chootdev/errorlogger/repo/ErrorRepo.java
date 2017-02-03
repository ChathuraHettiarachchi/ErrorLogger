package com.chootdev.errorlogger.repo;

import com.chootdev.errorlogger.database.DatabaseHelper;
import com.chootdev.errorlogger.database.DatabaseManager;
import com.chootdev.errorlogger.model.LoggerModel;

import java.sql.SQLException;
import java.util.List;

public class ErrorRepo implements Crud {
    private DatabaseHelper mHelper;

    public ErrorRepo() {
        mHelper = DatabaseManager.getInstance().getHelper();
        mHelper.getWritableDatabase();
        mHelper.getReadableDatabase();
    }

    @Override
    public int create(Object item) {
        int index = 1;
        LoggerModel object = (LoggerModel) item;
        try {
            return mHelper.getLoggerModelIntegerDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        LoggerModel object = (LoggerModel) item;

        try {
            mHelper.getLoggerModelIntegerDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;

    }

    @Override
    public LoggerModel findById(int id) {
        LoggerModel item = null;
        try {
            item = mHelper.getLoggerModelIntegerDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public List<?> findAll() {

        List<LoggerModel> items = null;

        try {
            items = mHelper.getLoggerModelIntegerDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public boolean truncate(Class<?> myclass) {
        boolean isDone = this.mHelper.truncateTable(myclass);
        return isDone;
    }
}
