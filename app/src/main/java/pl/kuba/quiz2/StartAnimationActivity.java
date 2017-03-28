package pl.kuba.quiz2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.widget.Toast.LENGTH_SHORT;

public class StartAnimationActivity extends AppCompatActivity {

    @BindView(R.id.dice)
    ImageView mDice;
    @BindView(R.id.quizgreeting)
    ImageView mQuizTime;
    @BindView(R.id.activity_start_animation)
    RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_animation);
        ButterKnife.bind(this);

        final Animation diceAnim = new AnimationUtils().loadAnimation(this, R.anim.rotateandgo);

        final Animation quizGreetingAnim = new AnimationUtils().loadAnimation(this, R.anim.quizfadein);

        diceAnim.setFillAfter(true);
        mQuizTime.setVisibility(View.INVISIBLE);
        diceAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mQuizTime.startAnimation(quizGreetingAnim);
                quizGreetingAnim.setFillAfter(true);
                mDice.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mDice.startAnimation(diceAnim);

        Toast.makeText(this,String.format("Aby przejść dalej dotknij ekran"), Toast.LENGTH_LONG).show();

    }
    @OnClick(R.id.activity_start_animation)
    void openNextScreen(){
        Intent startApp = new Intent(this, StartQuizActivity.class);
        startActivity(startApp);
    }
    }

