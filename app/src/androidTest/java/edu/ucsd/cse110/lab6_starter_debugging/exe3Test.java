package edu.ucsd.cse110.lab6_starter_debugging;

//public class exe3Test {
//}


import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import edu.ucsd.cse110.lab6_starter_debugging.model.db.AppDatabase;
import edu.ucsd.cse110.lab6_starter_debugging.model.db.Note;
import edu.ucsd.cse110.lab6_starter_debugging.model.db.NotesDao;
import edu.ucsd.cse110.lab6_starter_debugging.model.db.Person;
import edu.ucsd.cse110.lab6_starter_debugging.model.db.PersonDao;

@RunWith(AndroidJUnit4.class)
public class exe3Test {

    private PersonDao personDao;
    private NotesDao notesDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db.useTestSingleton(context);
        db = AppDatabase.singleton(context);
    }

    @Test
    public void testInsertPersonAndNotes() {

        Person person1 = new Person("Kurtis Ma");
        Person person2 = new Person("Ba Mai");

        db.personsDao().insert(person1);
        db.personsDao().insert(person2);

        Note note1 = new Note(person1.getPersonId(), "Kurtis new note");
        Note note2 = new Note(person2.getPersonId(), "Ba new note");

        db.notesDao().insert(note1);
        db.notesDao().insert(note2);

        assertEquals(2, db.personsDao().maxId()); //count people
        assertEquals(2, db.notesDao().maxId()); // count notes
    }
}