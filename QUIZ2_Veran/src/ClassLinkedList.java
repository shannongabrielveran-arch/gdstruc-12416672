class PlayerLinkedList {

    // Node class for singly linked list
    private static class Node {
        Player value;
        Node next;

        Node(Player value) {
            this.value = value;
        }
    }

    private Node head;
    private int size;    // in-place counter (auto-updates)

    public PlayerLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // add at the end of the list
    public void add(Player player) {
        Node newNode = new Node(player);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
    }

    // add at a specific index (0..size)
    public void add(int index, Player player) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        if (index == 0) {
            Node newNode = new Node(player);
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            Node newNode = new Node(player);
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    // remove first element (quiz requirement #1)
    public Player removeFirst() {
        if (head == null) {
            return null;
        }

        Player removed = head.value;
        head = head.next;
        size--;
        return removed;
    }

    // remove at a specific index
    public Player remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        if (index == 0) {
            return removeFirst();
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        Node removedNode = current.next;
        current.next = removedNode.next;
        size--;
        return removedNode.value;
    }

    // get element at index
    public Player get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    // contains() (quiz requirement #3)
    public boolean contains(Player player) {
        Node current = head;

        while (current != null) {
            if (current.value.equals(player)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // indexOf() (quiz requirement #3)
    public int indexOf(Player player) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.value.equals(player)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1; // not found
    }

    // helper to print the whole list
    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}

