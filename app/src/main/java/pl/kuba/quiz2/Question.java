package pl.kuba.quiz2;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable{
    private String question;
    private List<String> answers;
    private int correctAnswer;
    private String correctStringAnswers;

    public Question() {
    }

    public Question(String question, List<String> answers, String correctStringAnswers) {
        this.question = question;
        this.answers = answers;
        this.correctStringAnswers = correctStringAnswers;
    }



    public String getCorrectStringAnswers() {
        return correctStringAnswers;
    }

    public void setCorrectStringAnswers(String correctStringAnswers) {
        this.correctStringAnswers = correctStringAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
