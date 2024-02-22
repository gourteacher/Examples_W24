package com.college.examples;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface PersonDAO {
    @Insert
    void insertPerson(Person person);

    @Update
    void updatePerson(Person person);

    @Delete
    void deletePerson(Person person);

    @Query("SELECT * FROM person")
    List<Person> listPeople();

    @Query("DELETE FROM person WHERE last_name = :n")
    void deleteOnePerson(String n);

    @Query("DELETE FROM person")
    void deleteAll();
}