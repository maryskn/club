package com.example.myapplication.model.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

        @Query("SELECT * FROM login")
        List<User> getAll();
        @Insert
        void insertAll(User... users);

        @Insert
        void insertList(List<User> users);


        @Insert
        void insert(User... user);


        @Delete
        void delete(User users);


}
