package examproctor;

public class AnswerMap {

    private int[] questionIds;
    private String[] answers;
    private int size;

    AnswerMap(int capacity) {
        questionIds = new int[capacity];
        answers = new String[capacity];
        size = 0;
    }

    public void put(int questionId, String answer) {
        for (int i = 0; i < size; i++) {
            if (questionIds[i] == questionId) {
                answers[i] = answer;
                return;
            }
        }
        questionIds[size] = questionId;
        answers[size] = answer;
        size++;
    }

    public String get(int questionId) {
        for (int i = 0; i < size; i++) {
            if (questionIds[i] == questionId) {
                return answers[i];
            }
        }
        return null;
    }

    public int[] getAllQuestionIds() {
        int[] ids = new int[size];
        for (int i = 0; i < size; i++) {
            ids[i] = questionIds[i];
        }
        return ids;
    }
}