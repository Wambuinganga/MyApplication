package com.example.myapplication;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.database.DatabaseHelper;
import com.example.myapplication.database.Note;


public class ViewNote extends AppCompatActivity {
    int noteId;
    TextView tvTitle;
    TextView tvNoteText;
    Button btnDelete;


    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_view_note);
        getNoteId();
        tvTitle=findViewById(R.id.tvTitle);
        tvNoteText=findViewById(R.id.tvNoteText);
        btnDelete=findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper=new DatabaseHelper(getBaseContext(), "notes", null, 1);
                databaseHelper.deleteNote(noteId);
                finish();

            }
        });
    }

    public  void  getNoteId(){
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            noteId=bundle.getInt("NOTE_ID",0 );
        }
    }

    public void displayNote(){
        DatabaseHelper databaseHelper=new DatabaseHelper (getBaseContext(), "notes",null, 1);
        Note note=databaseHelper.getNoteById(noteId);
        tvTitle.setText(note.getTittle());
        tvNoteText.setText(note.getNoteText());
    }
}
