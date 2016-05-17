package info.krushik.android.student;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity4Editing extends AppCompatActivity {

    private EditText mEditTextFirstName;
    private EditText mEditTextLastName;
    private EditText mEditTextAge;
    private Button mButtonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        mEditTextFirstName = (EditText) findViewById(R.id.etFirstName);
        mEditTextLastName = (EditText) findViewById(R.id.etLastName);
        mEditTextAge = (EditText) findViewById(R.id.etAge);
        mButtonSave = (Button) findViewById(R.id.btnSave);

        Intent intent = getIntent();

        final Student student = intent.getParcelableExtra(MainActivity.EXTRA_STUDENT);

        mEditTextFirstName.setText(student.FirstName.toString());
        mEditTextLastName.setText(student.LastName.toString());
        if(student.Age != 0) {
            mEditTextAge.setText(String.valueOf(student.Age));
        }


        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent();
                student.FirstName = mEditTextFirstName.getText().toString();
                student.LastName = mEditTextLastName.getText().toString();
                student.Age = Integer.parseInt(mEditTextAge.getText().toString());

                if(student.Age == 0) {
                    Toast toast = Toast.makeText(Activity4Editing.this, R.string.toast_age_zero, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP, 0, 250);
                    toast.show();
                }else{
                    resultIntent.putExtra(MainActivity.EXTRA_STUDENT, student);

                    setResult(RESULT_OK, resultIntent);
                    finish();



                }
            }
        });
    }
}
