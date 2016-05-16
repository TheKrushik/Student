package info.krushik.android.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    public TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mTextView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        Student student = intent.getParcelableExtra(MainActivity.EXTRA_STUDENT);

        Toast.makeText(Activity2.this, R.string.toast_review, Toast.LENGTH_SHORT).show();

//        mTextView.setText(firstName + " " + lastName + ", age: " + age);
//        textView.setText(String.format("%s %s, age: %s", student.FirstName, student.LastName, student.Age));
        if(student.Age != 0) {
            mTextView.setText(student.toString());
        }
    }
}
