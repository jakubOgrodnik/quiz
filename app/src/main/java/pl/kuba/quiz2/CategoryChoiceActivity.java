package pl.kuba.quiz2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryChoiceActivity extends AppCompatActivity {

    @BindView(R.id.biology_button)
    Button mBiologyButton;
    @BindView(R.id.addition_button)
    Button mAdditionButton;
    @BindView(R.id.substraction_button)
    Button mSubstractionButton;

    private IQuestionsDatabase mQuestionDatabaseBiology = new BiologyRandomQuestionDatabase();
    private IQuestionsDatabase mQuestionDatabaseAddition = new AdditionRandomQuestionsDatabase();
    private IQuestionsDatabase mQuestionDatabeseSubstaction = new SubstractionRandomQuestionDatabase();
    private String mPlayerName;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorychoice);
        ButterKnife.bind(this);
        mPlayerName = getIntent().getStringExtra(QuestionsActivity.EXTRA_NAME);
    }

    @OnClick(R.id.biology_button)
    void openNextScreenBiology() {
        Intent biologyIntent = new Intent(this, QuestionsActivity.class);
        List<Question> questions = mQuestionDatabaseBiology.getQuestions();
        Random random = new Random();
        while (questions.size()>2){
            questions.remove(random.nextInt(questions.size()));
        }
        Collections.shuffle(questions);

        biologyIntent.putExtra(QuestionsActivity.EXTRA_QUESTIONS,  new ArrayList<> (questions));
        biologyIntent.putExtra(QuestionsActivity.EXTRA_NAME, mPlayerName);
        startActivity(biologyIntent);
    }

    @OnClick(R.id.addition_button)
    void openNextScreenAdd(){
        Intent addIntent = new Intent(this,QuestionsActivity.class);
        List<Question> questions = mQuestionDatabaseAddition.getQuestions();
        Random random = new Random();
        while (questions.size()>5){
            questions.remove(random.nextInt(questions.size()));
        }
        Collections.shuffle(questions);

        addIntent.putExtra(QuestionsActivity.EXTRA_QUESTIONS,  new ArrayList<> (questions));
        addIntent.putExtra(QuestionsActivity.EXTRA_NAME, mPlayerName);
        startActivity(addIntent);
    }

    @OnClick(R.id.substraction_button)
    void openNextScreenSubstract(){
        Intent subIntent = new Intent(this, QuestionsActivity.class);
        List<Question> questions = mQuestionDatabeseSubstaction.getQuestions();
        Random random = new Random();
        while (questions.size()> 5){
            questions.remove(random.nextInt(questions.size()));
        }
        Collections.shuffle(questions);

        subIntent.putExtra(QuestionsActivity.EXTRA_QUESTIONS,  new ArrayList<> (questions));
        subIntent.putExtra(QuestionsActivity.EXTRA_NAME, mPlayerName);
        startActivity(subIntent);
    }
}
