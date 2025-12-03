public class CardStack {

    private Card[] stack;
    private int top; // index of next free slot

    public CardStack(int capacity) {
        stack = new Card[capacity];
        top = 0;
    }

    public void push(Card card) {
        if (top == stack.length) {
            throw new IllegalStateException("Stack is full");
        }
        stack[top++] = card;
    }

    public Card pop() {
        if (isEmpty()) {
            return null;
        }
        Card card = stack[--top];
        stack[top] = null;
        return card;
    }

    public Card peek() {
        if (isEmpty()) {
            return null;
        }
        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }
}

