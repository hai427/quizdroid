package edu.washington.hai427.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        final int questionsAnswered = getIntent().getIntExtra("questionsAnswered", 0);
        Button finish;
        finish = (Button) findViewById(R.id.finish);
        if (questionsAnswered == 0) {
            finish.setText("Finish");
        } else {
            finish.setText("Next");
        }

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (questionsAnswered == 0) {
                    intent = new Intent(AnswerActivity.this, MainActivity.class);
                } else {
                    intent = new Intent(AnswerActivity.this, QuestionActivity.class);
                }

                intent.putExtra("questionsAnswered", questionsAnswered - 1);
                startActivity(intent);
                finish();
            }
        });
    }
}
