package com.example.lab1flashcardapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView flashcardQuestion;
    TextView flashcardAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flashcardQuestion = findViewById(R.id.flashcard_question);
        flashcardAnswer = findViewById(R.id.flashcard_answer);
        flashcardQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardQuestion.setVisibility(View.INVISIBLE);
                flashcardAnswer.setVisibility(View.VISIBLE);
            }
        });

        ImageView addQuestionImageView = findViewById(R.id.image_add_button);
        addQuestionImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("onActivityResult", "Success" + data.getExtras().getString("QuestionKey"));
        if (requestCode == 100) {
            //get data
            Log.d("onActivityResult", "requestCode == 100");
            if (data != null) {//check if there's an intent

                String QuestionString = data.getExtras().getString("QuestionKey");
                String AnswerString = data.getExtras().getString("AnswerKey");
                flashcardQuestion.setText(QuestionString);
                flashcardAnswer.setText(AnswerString);
                Log.d("onActivityResult", QuestionString + "; " + AnswerString);
            }
        }
    }
}
