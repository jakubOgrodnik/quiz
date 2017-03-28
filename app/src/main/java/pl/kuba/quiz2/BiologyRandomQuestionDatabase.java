package pl.kuba.quiz2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BiologyRandomQuestionDatabase implements IQuestionsDatabase{

    @Override
    public List<Question> getQuestions() {
        List<Question> questions = new LinkedList<>();
        Random random = new Random();
        List<String> answers1 = new LinkedList<>();
        answers1.add("Palma");
        answers1.add("Kokos");
        answers1.add("Eukaliptus");
        List<String> answers2 = new LinkedList<>();
        answers2.add("Sok");
        answers2.add("Mleko");
        answers2.add("Jad");
        Question questions1 = new Question("Główne pożywienie koali to:", answers1 , "Eukaliptus");
        Question questions2 = new Question("Wąż wstrzykuje:",answers2, "Jad");



        int correctPosition = random.nextInt(3);

        questions1.setAnswers(answers1);
        questions1.setCorrectAnswer(correctPosition);
        questions2.setAnswers(answers2);
        questions2.setCorrectAnswer(correctPosition);

        answers1.set(correctPosition, questions1.getCorrectStringAnswers());
        answers2.set(correctPosition, questions2.getCorrectStringAnswers());

        questions.add(questions1);
        questions.add(questions2);
        return questions;
    }

}
