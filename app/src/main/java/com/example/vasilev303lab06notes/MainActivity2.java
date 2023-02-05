package com.example.vasilev303lab06notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    int note_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        note_id = i.getIntExtra("open_note_id", -1);
    }

    public void on_but_save_click(View v)
    {
        EditText et_title = findViewById(R.id.txt_title);
        EditText et_content = findViewById(R.id.txt_content);

        NoteManager.updateNote(note_id,
                et_title.getText().toString(),
                et_content.getText().toString());

        finish();
    }

    public void on_but_delete_click(View v)
    {
        NoteManager.deleteNote(note_id);
        finish();
        Toast.makeText(this, "Заметка была удалена", Toast.LENGTH_LONG).show();
    }

    public void on_but_close_click(View v)
    {
        finish();
    }
}