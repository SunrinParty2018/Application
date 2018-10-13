package com.example.david0926.dreamtree;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

public class Dialog_Parse extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_parse);

        TextView word, name;
        word = findViewById(R.id.dialog_parse_word);
        name = findViewById(R.id.dialog_parse_name);
        Intent intent = getIntent();
        word.setText(intent.getStringExtra("word"));
        name.setText(intent.getStringExtra("name"));


    }
}
