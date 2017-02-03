package com.chootdev.errorlogger.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.chootdev.errorlogger.model.LoggerModel;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "errorlogger.db";

    private Dao<LoggerModel, Integer> loggerModelIntegerDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, LoggerModel.class);
        } catch (android.database.SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, LoggerModel.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean truncateTable(Class<?> object) {
        boolean isDone = false;
        try {
            int i = TableUtils.dropTable(getConnectionSource(), object, true);
            i = TableUtils.createTable(getConnectionSource(), object);

            if (i > 0) {
                isDone = true;
            }
        } catch (java.sql.SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return isDone;
    }

    public Dao<LoggerModel, Integer> getLoggerModelIntegerDao() {
        if (null == loggerModelIntegerDao) {
            try {
                loggerModelIntegerDao = getDao(LoggerModel.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return loggerModelIntegerDao;
    }
}
