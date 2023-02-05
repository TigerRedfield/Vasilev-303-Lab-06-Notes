package com.example.vasilev303lab06notes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    ArrayAdapter<Note> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adp = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, NoteManager.notes);

        ListView lv_notes = findViewById(R.id.list_Notes);
        lv_notes.setAdapter(adp);

        final Context ctx = this;
        lv_notes.setOnItemClickListener((parent, view, position, id) -> {
            Note n = (Note) adp.getItem(position);
            Intent i = new Intent(ctx, MainActivity2.class);
            i.putExtra("open_note_id", n.id);
            startActivityForResult(i, 12345);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        adp.notifyDataSetChanged();
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void on_but_add_click(View v)
    {
        int note_id = NoteManager.createNote("New note title", "new note content");
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("open_note_id", note_id);
        startActivityForResult(i,12345);
    }
}

