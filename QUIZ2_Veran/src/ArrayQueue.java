import java.util.NoSuchElementException;

public class ArrayQueue {

    private Player[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Player[capacity];
        front = 0;
        back = 0;
    }

    // enqueue
    public void add(Player player) {
        // resize if array is full
        if (back == queue.length) {
            Player[] newArray = new Player[queue.length * 2];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }

        queue[back] = player;
        back++;
    }

    // dequeue
    public Player remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Player removedPlayer = queue[front];
        queue[front] = null;
        front++;

        // reset indices when queue becomes empty
        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return removedPlayer;
    }

    public Player peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        if (size() == 0) {
            System.out.println("(queue is empty)");
            return;
        }

        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
