package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.adapters.NotesAdapter;
import com.example.myapplication.database.DatabaseHelper;
import com.example.myapplication.database.Note;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    List<Note>noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),AddNoteActivity.class));
            }
        });
        listview=findViewById(R.id.lvListView);
    }

    private void displayNote(){
        DatabaseHelper databaseHelper=new DatabaseHelper(getBaseContext(),"notes", null, 1);
        noteList=new ArrayList<Note>();
        noteList=databaseHelper.getNotes();
        Log.d("mynote", "my database has "+ "notes");
        NotesAdapter notesAdapter=new NotesAdapter(getBaseContext(),0, noteList);
        listview.setAdapter(notesAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note clickedNote=noteList.get(position);
                Intent intent=new Intent(getBaseContext(), ViewNote.class);
                intent.putExtra("NOTE_ID", clickedNote.getId());
                startActivity(intent);
            }
        });

    }
    public void displayName(){
        List<String>namesList=new ArrayList<String>();
        namesList.add("Wambui Ng'ang'a");
        namesList.add("Tracy Baraza");
        namesList.add("Joanne Aluka");
        namesList.add("Natasha Nasambu");
        namesList.add("Ann Karanja");
        namesList.add("Lucian Wambui");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, namesList);
        listview.setAdapter(arrayAdapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        displayNote();


//        displayName();
    }




    }
