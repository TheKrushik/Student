package info.krushik.android.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity3 extends AppCompatActivity {

    private EditText mEditTextFirstName;
    private EditText mEditTextLastName;
    private EditText mEditTextAge;
    private Button mButtonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        mEditTextFirstName = (EditText) findViewById(R.id.etFirstName);
        mEditTextLastName = (EditText) findViewById(R.id.etLastName);
        mEditTextAge = (EditText) findViewById(R.id.etAge);
        mButtonSave = (Button) findViewById(R.id.btnSave);

        Intent intent = getIntent();
        String textFirstName = intent.getStringExtra(MainActivity.EXTRA_FIRSTNAME);
        String textLastName = intent.getStringExtra(MainActivity.EXTRA_LASTNAME);
        String textAge = intent.getStringExtra(MainActivity.EXTRA_AGE);

        mEditTextFirstName.setText(textFirstName);
        mEditTextLastName.setText(textLastName);
        mEditTextAge.setText(textAge);

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(MainActivity.EXTRA_FIRSTNAME, mEditTextFirstName.getText().toString());
                resultIntent.putExtra(MainActivity.EXTRA_LASTNAME, mEditTextLastName.getText().toString());
                resultIntent.putExtra(MainActivity.EXTRA_AGE, mEditTextAge.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

    }
}
