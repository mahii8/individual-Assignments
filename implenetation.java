class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null; // Initially, there is no next node
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        this.head = null; // Initially, the list is empty
    }

    // Inserting an element at a specified position
    void insertAtPos(int position, int data) {
        Node newNode = new Node(data);
        if (position <= 0) {
            System.out.println("Please provide a valid position.");
            return;
        }
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        int currentPosition = 1;
        while (currentPosition < position - 1 && current != null) {
            current = current.next;
            currentPosition++;
        }
        if (current == null) {
            System.out.println("Position exceeds the length of the list. Inserting at the end.");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Deleting an element at a specified position
    void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (position == 1) {
            head = head.next;
            return;
        }
        Node current = head;
        int currentPosition = 1;
        while (currentPosition < position - 1 && current != null) {
            current = current.next;
            currentPosition++;
        }
        if (current == null || current.next == null) {
            System.out.println("Position exceeds the length of the list.");
            return;
        }
        current.next = current.next.next;
    }

    // Deleting the element after a given node
    void deleteAfterNode(Node prevNode) {
        if (prevNode == null || prevNode.next == null) {
            System.out.println("Cannot delete. Either previous node is null or it's the last node.");
            return;
        }
        prevNode.next = prevNode.next.next;
    }

    // Searching for an element in the list
    Node searchNode(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}

class Stack {
    Node top;

    Stack() {
        this.top = null;
    }

    // Pushing an element onto the stack
    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Popping an element from the stack
    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    // Peeking at the top element of the stack
    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return top.data;
    }

    // Checking if the stack is empty
    boolean isEmpty() {
        return top == null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a linked list
        LinkedList linkedList = new LinkedList();

        // Inserting elements
        linkedList.insertAtPos(1, 10);
        linkedList.insertAtPos(2, 20);
        linkedList.insertAtPos(3, 30);

        // Deleting an element
        linkedList.deleteAtPosition(2);

        // Displaying the updated list
        System.out.println("Updated List:");
        Node current = linkedList.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");

        // Searching for an element
        Node foundNode = linkedList.searchNode(20);
        if (foundNode != null) {
            System.out.println("Found Node: " + foundNode.data);
        } else {
            System.out.println("Node not found.");
        }

        // Creating a stack
        Stack stack = new Stack();

        // Pushing elements to the stack
        stack.push(50);
        stack.push(60);
        stack.push(70);

        // Popping an element from the stack
        int poppedElement = stack.pop();
        System.out.println("Popped Element: " + poppedElement);

        // Peeking at the top of the stack
        int topElement = stack.peek();
        System.out.println("Top Element: " + topElement);
    }
}