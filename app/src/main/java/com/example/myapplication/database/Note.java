package com.example.myapplication.database;

public class Note {
    private  int id;
    private  String tittle;
    private String noteText;

    public Note(int id, String tittle, String noteText) {
        this.id = id;
        this.tittle = tittle;
        this.noteText = noteText;
    }

    public Note(String tittle, String noteText) {
        this.tittle = tittle;
        this.noteText = noteText;
    }

    public Note() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

}
