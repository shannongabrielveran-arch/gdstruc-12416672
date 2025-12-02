

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Player> playerList = new LinkedList<>();
        int size = 0; // in-place counter

        // Add elements
        playerList.add(new Player(1, 100, "Blair"));
        playerList.add(new Player(2, 205, "ZXen0on"));
        playerList.add(new Player(3, 34, "Yukio"));
        size = playerList.size();

        System.out.println("Initial list:");
        printList(playerList);

        // Remove first element
        removeFirst(playerList);
        size = playerList.size();

        System.out.println("\nAfter removing first element:");
        printList(playerList);
        System.out.println("Current size: " + size);

        // Check contains()
        System.out.println("\nContains LethaBacon (id=2)? " +
                contains(playerList, new Player(2, 205, "LethaBacon")));

        // Check indexOf()
        System.out.println("Index of HPDeskjet: " +
                indexOf(playerList, new Player(3, 34, "HPDeskjet")));
    }

    // Removes the first element of the LinkedList
    public static void removeFirst(LinkedList<Player> list) {
        if (!list.isEmpty()) {
            list.removeFirst();
        } else {
            System.out.println("List is already empty.");
        }
    }

    // Checks if LinkedList contains a specific player
    public static boolean contains(LinkedList<Player> list, Player player) {
        for (Player p : list) {
            if (p.equals(player)) {
                return true;
            }
        }
        return false;
    }

    // Finds the index of a specific player in LinkedList
    public static int indexOf(LinkedList<Player> list, Player player) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(player)) {
                return i;
            }
        }
        return -1; // not found
    }

    // Helper method to print the list
    public static void printList(LinkedList<Player> list) {
        for (Player p : list) {
            System.out.println(p);
        }
    }
}
