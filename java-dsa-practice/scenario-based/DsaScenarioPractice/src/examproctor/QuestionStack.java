package examproctor;

public class QuestionStack {

    private int[] stack;
    private int top;

    public QuestionStack(int size) {
        stack = new int[size];
        top = -1;
    }

    public void push(int questionId) {
        if (top == stack.length - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stack[++top] = questionId;
        System.out.println("Visited Question: " + questionId);
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return -1;
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}