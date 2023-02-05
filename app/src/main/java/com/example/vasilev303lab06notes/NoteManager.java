package com.example.vasilev303lab06notes;

import java.util.ArrayList;


public class NoteManager {
    static public ArrayList <Note> notes = new ArrayList <Note> ();

    //C.R.U.D. (create, read, update, delete)

    static public Note getNote (int id)
    {
      for(int i=0; i<notes.size(); i++)
      {
          Note n = notes.get(i);
          if(n.id == id) return n;

      }
      return null;
    }

    static public void deleteNote(int id)
    {
        Note n = getNote(id);
        if (n!=null) notes.remove(n);
    }

    static public int createNote(String title, String content)
    {
        Note n = new Note(title, content);
        notes.add(n);
        return n.id;
    }

    static public void updateNote(int id,String title, String content)
    {
        Note n = getNote(id);
        if(n==null) return;
        n.title = title;
        n.content = content;
    }
}

