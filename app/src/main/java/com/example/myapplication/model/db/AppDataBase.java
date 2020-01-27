package com.example.myapplication.model.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.myapplication.MyApplication;

@Database(entities = {User.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase appDatabase;

    public abstract UserDao userDao();

    public static AppDataBase getAppDatabase() {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(MyApplication.getMyApplication().getcontext(), AppDataBase.class, "user").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
