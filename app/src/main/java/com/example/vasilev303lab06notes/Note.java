package com.example.vasilev303lab06notes;

public class Note {
    private static int next_id = 0; //счётчик индекса

    public int id; //номер индекса
    public String title; //название
    public String content; //содержимое

    public Note(String title, String content)
    {
        id = next_id;
        next_id++;
        this.title = title;
        this.content = content;
    }

    public String toString()
    {
        return title;
    }
}
