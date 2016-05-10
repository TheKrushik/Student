package info.krushik.android.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    public TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mTextView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        Student student = intent.getParcelableExtra(MainActivity.EXTRA_STUDENT);

//        textView.setText(student.FirstName + " " + student.LastName + " " + student.Age);
//
//        textView.setText(String.format("%s %s, age: %s", student.FirstName, student.LastName, student.Age));

        mTextView.setText(student.toString());
    }
}
