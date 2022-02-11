package edu.ucsd.cse110.lab6_starter_debugging.model.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface PersonDao {
    @Query("SELECT * FROM persons")
    List<Person> getAll();

    @Query("SELECT * FROM persons WHERE person_id=:id")
    Person get(int id);

    @Query("SELECT MAX(person_id) from persons")
    int maxId();

    @Insert
    void insert(Person person);
}
