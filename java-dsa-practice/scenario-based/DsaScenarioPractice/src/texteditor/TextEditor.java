package texteditor;

import java.util.Stack;

class TextEditor {

    private String content = "";
    private Stack<Action> undoStack = new Stack<>();
    private Stack<Action> redoStack = new Stack<>();

    
    public void insert(String text) {
        content += text;
        undoStack.push(new Action("insert", text));
        redoStack.clear();
    }

    
    public void delete(String text) {
        content = content.replace(text, "");
        undoStack.push(new Action("delete", text));
        redoStack.clear();
    }

    
    public void undo() {
        if (!undoStack.isEmpty()) {
            Action action = undoStack.pop();

            if (action.actionType.equals("insert")) {
                content = content.replace(action.text, "");
            } else if (action.actionType.equals("delete")) {
                content += action.text;
            }

            redoStack.push(action);
        }
    }

    
    public void redo() {
        if (!redoStack.isEmpty()) {
            Action action = redoStack.pop();

            if (action.actionType.equals("insert")) {
                content += action.text;
            } else if (action.actionType.equals("delete")) {
                content = content.replace(action.text, "");
            }

            undoStack.push(action);
        }
    }

    public void showContent() {
        System.out.println("Text: " + content);
    }
}