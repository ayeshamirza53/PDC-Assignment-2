public class TransactionStack {
    private char[] stackArray;
    private int top;

    public TransactionStack(int capacity) {
        stackArray = new char[capacity];
        top = -1;
    }

    public void push(char c) {
        if (top < stackArray.length - 1) {
            stackArray[++top] = c;
        }
    }

    public char pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        }
        return '\0';
    }

    public char peek() {
        if (!isEmpty()) {
            return stackArray[top];
        }
        return '\0';
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
// Updated for PDC Lab Assignment 2

// Update commit log

// Incremental commit update
