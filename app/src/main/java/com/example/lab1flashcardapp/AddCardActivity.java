package com.example.lab1flashcardapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.image_remove_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    finish();
            }
        });

        ImageView saveQuestionImageView = findViewById(R.id.image_save_button);
        saveQuestionImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                String inputQuestion = ((EditText) findViewById(R.id.setQuestion)).getText().toString();
                String inputAnswer = ((EditText) findViewById(R.id.inputAnswer)).getText().toString();
                //Log.d("AddCardActivity", "hi" + inputQuestion + ", " + inputAnswer );
                data.putExtra("QuestionKey",inputQuestion);
                data.putExtra("AnswerKey",inputAnswer);
                String str = data.getExtras().getString("QuestionKey");
                //Log.d("AddCardActivity", "hi" + str );
                setResult(RESULT_OK, data);
                finish();

            }
        });


    }
}