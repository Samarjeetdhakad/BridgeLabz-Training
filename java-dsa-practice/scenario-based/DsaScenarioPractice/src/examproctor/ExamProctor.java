package examproctor;

public class ExamProctor {

    private QuestionStack navigation;
    private AnswerMap studentAnswers;
    private AnswerMap correctAnswers;

    ExamProctor() {
        navigation = new QuestionStack(10);
        studentAnswers = new AnswerMap(10);
        correctAnswers = new AnswerMap(10);

        // Correct answers
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "C");
        correctAnswers.put(4, "D");
    }

    public void visitQuestion(int qId) {
        navigation.push(qId);
    }

    public void submitAnswer(int qId, String answer) {
        studentAnswers.put(qId, answer);
        System.out.println("Answer saved for Q" + qId);
    }

    public void goBack() {
        int last = navigation.pop();
        if (last != -1) {
            System.out.println("Back to Question: " + last);
        }
    }

    // Function for scoring
    public int calculateScore() {
        int score = 0;
        int[] attempted = studentAnswers.getAllQuestionIds();

        for (int qId : attempted) {
            String student = studentAnswers.get(qId);
            String correct = correctAnswers.get(qId);
            if (student != null && student.equals(correct)) {
                score++;
            }
        }
        return score;
    }
}