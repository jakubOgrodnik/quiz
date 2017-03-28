package pl.kuba.quiz2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class QuizResultDialogFragment extends DialogFragment {

    public static final String PLAYER_NAME = "playerName";
    public static final String CORRECT_ANSWERS = "correctAnswers";
    public static final String QUESTION_COUNT = "questionCount";

    public static QuizResultDialogFragment createDialog (String playerName, int correctAnswers, int questionCount){
        QuizResultDialogFragment fragment = new QuizResultDialogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        args.putString(PLAYER_NAME, playerName);
        args.putInt(CORRECT_ANSWERS, correctAnswers);
        args.putInt(QUESTION_COUNT, questionCount);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String playerName = getArguments().getString(PLAYER_NAME);
        int correctAnswers = getArguments().getInt(CORRECT_ANSWERS);
        int questionCount = getArguments().getInt(QUESTION_COUNT);

        setCancelable(false);
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Wynik quizu")
                .setMessage(String.format("Witaj %s! Twoj wynik to: %d/%d!",
                        playerName, correctAnswers,questionCount))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                })
                .create();
        return dialog;
    }
}
