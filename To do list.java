class Task {
    public String title;
    public String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class ToDoList {
    Node head;

    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                break;
            }
            current = current.next;
        }
    }

    public void viewToDoList() {
        Node current = head;
        while (current != null) {
            System.out.println("Title: " + current.task.getTitle());
            System.out.println("Description: " + current.task.getDescription());
            System.out.println("Completed: " + current.task.isCompleted());
            System.out.println("----------------------");
            current = current.next;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // Create a new to-do list
        ToDoList toDoList = new ToDoList();

        // Create tasks
        Task task1 = new Task("Finish DSA project", "Complete the project  by Friday.");
        Task task2 = new Task("Go shopping", "Buy milk, eggs, and bread.");
        Task task3 = new Task("Exercise", "Go for a 30-minute Walk.");

        // Add tasks to the to-do list
        toDoList.addToDo(task1);
        toDoList.addToDo(task2);
        toDoList.addToDo(task3);

        // View the to-do list
        System.out.println("To-Do List:");
        toDoList.viewToDoList();
        System.out.println();

        // Mark a task as completed
        toDoList.markToDoAsCompleted("Grocery shopping");

        // View the updated to-do list
        System.out.println("Updated To-Do List:");
        toDoList.viewToDoList();
    }
}