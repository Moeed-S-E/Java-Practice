import java.util.LinkedList;
public class UndoRedoSystem {
    private LinkedList<String> undoStack;
    private LinkedList<String> redoStack;
    public UndoRedoSystem(){
        undoStack = new LinkedList<>();
        redoStack = new LinkedList<>();
    }
    public void performAction(String action){
        undoStack.push(action);
        redoStack.clear();
    }
    public void undo(){
        if (!undoStack.isEmpty()) {
            String action = undoStack.pop();
            redoStack.push(action);
            System.out.println("Undone: "+ action);
        }else{
            System.out.println("nothing to undo..");
        }
    }
    public void redo(){
        if (!redoStack.isEmpty()) {
            String action = redoStack.pop();
            undoStack.push(action);
            System.out.println("Redone: "+action);
        }else{
            System.out.println("nothing to redo..");
        }
    }
    public void display(){
        System.out.println("Undo Stack: "+undoStack);
        System.out.println("Redo Stack: "+redoStack);
    }

    public static void main(String[] args) {
        UndoRedoSystem system = new UndoRedoSystem();
        system.performAction("Hello World");
        system.performAction("Hello World 2");
        system.performAction("Hello World 3");

        system.display();

        system.undo();
        system.display();

        system.redo();
        system.display();

    }
}
