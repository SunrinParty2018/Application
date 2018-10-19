package com.example.david0926.dreamtree;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Dialog_Parse extends AppCompatActivity{

    TextView word, name;
    Button btn_parsesave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_parse);


        word = findViewById(R.id.dialog_parse_word);
        name = findViewById(R.id.dialog_parse_name);
        Intent intent = getIntent();
        word.setText(intent.getStringExtra("word"));
        name.setText(intent.getStringExtra("name"));

        btn_parsesave = findViewById(R.id.btn_parsesave);
        btn_parsesave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "명언을 저장했습니다!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
