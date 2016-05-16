package info.krushik.android.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_STUDENT = "info.krushik.android.student.extra.STUDENT";
//    public static final String EXTRA_FIRSTNAME = "info.krushik.android.student.extra.FIRSTNAME";
//    public static final String EXTRA_LASTNAME = "info.krushik.android.student.extra.LASTNAME";
//    public static final String EXTRA_AGE = "info.krushik.android.student.extra.AGE";
    private static final int REQUEST_CODE_ACTIVITY3 = 1;

    private TextView mTextViewFirstName;
    private TextView mTextViewLastName;
    private TextView mTextViewAge;
    private Button mButtonReview;
    private Button mButtonEditing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewFirstName = (TextView) findViewById(R.id.tvFirstName);
        mTextViewLastName = (TextView) findViewById(R.id.tvLastName);
        mTextViewAge = (TextView) findViewById(R.id.tvAge);

    }

    public void OnClick(View v) {
        Student student = new Student();
        student.FirstName = mTextViewFirstName.getText().toString();
        student.LastName = mTextViewLastName.getText().toString();
        if(mTextViewAge.getText().toString() != ""){
            student.Age = Integer.parseInt(mTextViewAge.getText().toString());
        }


        switch (v.getId()) {
            case R.id.tvFirstName:
            case R.id.tvLastName:
            case R.id.tvAge:
                PopupMenu popupMenu = new PopupMenu(this, mTextViewAge);
                popupMenu.inflate(R.menu.menu_popup);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem){
                        Student student = new Student();
                        student.FirstName = mTextViewFirstName.getText().toString();
                        student.LastName = mTextViewLastName.getText().toString();
                        if(mTextViewAge.getText().toString() != ""){
                            student.Age = Integer.parseInt(mTextViewAge.getText().toString());
                        }

                        switch (menuItem.getItemId()) {
                            case R.id.menu_review:
                                Intent intent = new Intent(MainActivity.this, Activity2.class);
                                intent.putExtra(EXTRA_STUDENT, student);
                                startActivity(intent);
                                break;
                            case R.id.menu_editing:
                                Intent intent3 = new Intent(MainActivity.this, Activity3.class);
                                intent3.putExtra(EXTRA_STUDENT, student);

                                startActivityForResult(intent3, REQUEST_CODE_ACTIVITY3);
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
                break;
            case R.id.btnReview:
                Intent intent = new Intent(this, Activity2.class);
                intent.putExtra(EXTRA_STUDENT, student);

                startActivity(intent);
                break;
            case R.id.btnEditing:
                Intent intent3 = new Intent(this, Activity3.class);
                intent3.putExtra(EXTRA_STUDENT, student);

                startActivityForResult(intent3, REQUEST_CODE_ACTIVITY3);
                break;
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ACTIVITY3 && resultCode == RESULT_OK) {
            Student student = data.getParcelableExtra(EXTRA_STUDENT);

            mTextViewFirstName.setText(student.FirstName.toString());
            mTextViewLastName.setText(student.LastName.toString());
            mTextViewAge.setText(String.valueOf(student.Age));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
