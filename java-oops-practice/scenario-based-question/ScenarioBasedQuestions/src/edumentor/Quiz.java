package edumentor;

class Quiz {

    private String[] questions;        
    private final String[] answers;    
    private int score;


    public Quiz(String[] questions, String[] answers) {
        this.questions = questions;
        this.answers = answers;
    }

   
    public Quiz(String[] questions, String[] answers, String difficulty) {
        this.questions = questions;
        this.answers = answers;

        if (difficulty.equalsIgnoreCase("Hard")) {
            score = 0;
        }
    }

    public void evaluate(String[] userAnswers) {
        score = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equals(userAnswers[i])) {
                score++;   
            }
        }
    }

    public double calculatePercentage() {
        return (score * 100.0) / answers.length; 
    }
}
