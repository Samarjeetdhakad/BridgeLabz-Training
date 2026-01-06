package edumentor;

public class EduMentorApp {
    public static void main(String[] args) {

        Learner learner = new Learner(1, "Samarjeet", "sam@edu.com", "Full-Time");
        Instructor instructor = new Instructor(101, "Dr. Rao", "rao@edu.com", "AI");

        String[] questions = {
            "What is OOP?",
            "What is Polymorphism?"
        };

        String[] answers = {
            "Object Oriented Programming",
            "Many Forms"
        };

        Quiz quiz = new Quiz(questions, answers, "Easy");

        String[] userAnswers = {
            "Object Oriented Programming",
            "Many Forms"
        };

        quiz.evaluate(userAnswers);

        System.out.println("Score Percentage: " + quiz.calculatePercentage());

        learner.generateCertificate();  
    }
}

