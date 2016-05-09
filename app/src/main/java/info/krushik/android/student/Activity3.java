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
    private Button mButtonFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        mEditTextFirstName = (EditText) findViewById(R.id.etFirstName);
        mEditTextLastName = (EditText) findViewById(R.id.etLastName);
        mEditTextAge = (EditText) findViewById(R.id.etAge);
        mButtonFinish = (Button) findViewById(R.id.btnFinish);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_FIRSTNAME);

        mEditTextFirstName.setText(text);
        mEditTextLastName.setText(text);
        mEditTextAge.setText(text);

        mButtonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(MainActivity.EXTRA_FIRSTNAME, mEditTextFirstName.getText().toString());
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });

    }
}
