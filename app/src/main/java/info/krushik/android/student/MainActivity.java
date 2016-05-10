package info.krushik.android.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_STUDENT = "info.krushik.android.student.extra.STUDENT";
    private static final int REQUEST_CODE_ACTIVITY3 = 1;

    private TextView mTvFirstName;
    private TextView mTvLastName;
    private TextView mTvAge;
    private Button mBtnReview;
    private Button mBtnEditing;


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
                intent.putExtra(EXTRA_STUDENT, student);
                startActivity(intent);

                break;
            case R.id.btnEditing:
                Intent intent2 = new Intent(this, Activity3.class);
                Student student2 = new Student("Ivan", "Ivanov", 22);
                intent2.putExtra(EXTRA_STUDENT, student2);

                startActivityForResult(intent2, REQUEST_CODE_ACTIVITY3);

                break;
        }

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ACTIVITY3 && resultCode == RESULT_OK){
            String text =  data.getStringExtra(EXTRA_STUDENT);
            mTvFirstName.setText(text);
        }
    }
}
