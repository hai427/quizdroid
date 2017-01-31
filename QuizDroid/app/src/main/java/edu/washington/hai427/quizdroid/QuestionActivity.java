package edu.washington.hai427.quizdroid;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuestionActivity extends AppCompatActivity {

    private static final String TAG = "question";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        Button submitButton;
        submitButton = (Button) findViewById(R.id.submit);
        submitButton.setEnabled(false);
        submitButton.setClickable(false);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionActivity.this, AnswerActivity.class);
                int questionsAnswered = getIntent().getIntExtra("questionsAnswered", 0);
                intent.putExtra("questionsAnswered", questionsAnswered);
                startActivity(intent);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        Button submitButton = (Button) findViewById(R.id.submit);

        submitButton.setEnabled(true);
        submitButton.setClickable(true);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.questionOne:
                if (checked)
                    Log.i(TAG, "Submitting 1");
            case R.id.questionTwo:
                if (checked)
                    Log.i(TAG, "Submitting 2");
            case R.id.questionThree:
                if (checked)
                    Log.i(TAG, "Submitting 3");
            case R.id.questionFour:
                if (checked)
                    Log.i(TAG, "Submitting 4");;
        }
    }
}
