public class RequestQueue {
    private char[] queueArray;
    private int front;
    private int rear;
    private int size;

    public RequestQueue(int capacity) {
        queueArray = new char[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(char c) {
        if (size < queueArray.length) {
            rear = (rear + 1) % queueArray.length;
            queueArray[rear] = c;
            size++;
        }
    }

    public char dequeue() {
        if (!isEmpty()) {
            char item = queueArray[front];
            front = (front + 1) % queueArray.length;
            size--;
            return item;
        }
        return '\0';
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
// Updated for PDC Lab Assignment 2

// Update commit log
