public class Tree {

    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.insert(value);
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    // Optional helper to search for a value
    public Node get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    // ===== QUIZ #6 FUNCTIONS =====

    // Node with the least value in the tree
    public Node getMin() {
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current;
    }

    // Node with the maximum value in the tree
    public Node getMax() {
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current;
    }

    // In-order traversal but in DESCENDING order
    public void traverseInOrderDescending() {
        if (root != null) {
            root.traverseInOrderDescending();
        }
    }
}

