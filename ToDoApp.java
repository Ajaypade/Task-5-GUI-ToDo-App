package ui;

import model.Task;
import service.TaskManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoApp extends JFrame {
    private TaskManager taskManager;
    private DefaultListModel<Task> listModel;
    private JList<Task> taskList;
    private JTextField taskInput;

    public ToDoApp(TaskManager manager) {
        this.taskManager = manager;

        // Frame settings
        setTitle("To-Do List App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel
        JPanel panel = new JPanel(new BorderLayout());

        // Input field
        taskInput = new JTextField();
        panel.add(taskInput, BorderLayout.NORTH);

        // List
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = taskInput.getText().trim();
                if (!text.isEmpty()) {
                    taskManager.addTask(text);
                    refreshList();
                    taskInput.setText("");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = taskList.getSelectedIndex();
                if (index != -1) {
                    taskManager.removeTask(index);
                    refreshList();
                }
            }
        });

        add(panel);
    }

    private void refreshList() {
        listModel.clear();
        for (Task t : taskManager.getTasks()) {
            listModel.addElement(t);
        }
    }
}
