package info.krushik.android.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_STUDENT = "info.krushik.android.student.extra.STUDENT";
    public static final String EXTRA_FIRSTNAME = "info.krushik.android.student.extra.FIRSTNAME";
    public static final String EXTRA_LASTNAME = "info.krushik.android.student.extra.LASTNAME";
    public static final String EXTRA_AGE = "info.krushik.android.student.extra.AGE";
    private static final int REQUEST_CODE_ACTIVITY3 = 1;

    private TextView mTvFirstName;
    private TextView mTvLastName;
    private TextView mTvAge;
//    private Button mBtnReview;
//    private Button mBtnEditing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvFirstName = (TextView)findViewById(R.id.tvFirstName);
        mTvLastName = (TextView)findViewById(R.id.tvLastName);
        mTvAge = (TextView)findViewById(R.id.tvAge);

    }

    public void OnClick(View v){
        switch (v.getId()){
            case R.id.btnReview:
                Intent intent = new Intent(this, Activity2.class);
                Student student = new Student();
                intent.putExtra(EXTRA_SUDENT, student);
                startActivity(intent);

                break;
            case R.id.btnEditing:
                Intent intent2 = new Intent(this, Activity3.class);
                intent2.putExtra(EXTRA_FIRSTNAME, mTvFirstName.getText().toString());

                startActivityForResult(intent2, REQUEST_CODE_ACTIVITY3);

                break;
        }

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ACTIVITY3 && resultCode == RESULT_OK){
            String text =  data.getStringExtra(EXTRA_FIRSTNAME);
            mTvFirstName.setText(text);
        }
    }
}
