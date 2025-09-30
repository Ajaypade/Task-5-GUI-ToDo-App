# Task-5-GUI-ToDo-App

The app is a Java Swing To-Do list with separate classes for clarity.
Task (Model) represents a single to-do item with description.
TaskManager (Service) manages adding, removing, and storing tasks in a list.
ToDoApp (UI) extends JFrame to create the GUI.
It uses JTextField for entering new tasks.
JList + DefaultListModel display tasks dynamically.
A JScrollPane allows scrolling when tasks exceed visible space.
Two buttons: Add Task and Delete Task.
ActionListener handles button clicks.
On Add: task from input is added to TaskManager and shown in list.
On Delete: selected task is removed from TaskManager and list.
refreshList() updates UI to match current task list.
Main class starts the app by creating TaskManager + ToDoApp.
Structure follows MVC (Model–View–Controller) style separation.
Outcome: Learn event handling, layout, and GUI programming in Java Swing.
