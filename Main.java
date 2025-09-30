import service.TaskManager;
import ui.ToDoApp;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        ToDoApp app = new ToDoApp(manager);
        app.setVisible(true);
    }
}
