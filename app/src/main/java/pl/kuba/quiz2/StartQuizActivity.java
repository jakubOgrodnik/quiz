package pl.kuba.quiz2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartQuizActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "name";
    @BindView(R.id.name_field )
    EditText mEditText;

    private IQuestionsDatabase  mQuestionsDatabase = new AdditionRandomQuestionsDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.next_button)
    void openNextScreen(){
        String name = mEditText.getText().toString();
        Intent nameIntent = new Intent(this, CategoryChoiceActivity.class);
        nameIntent.putExtra(EXTRA_NAME, name);
        startActivity(nameIntent);
    }
}
