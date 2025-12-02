public class Main {

    public static void main(String[] args) {

        PlayerLinkedList playerList = new PlayerLinkedList();

        // add players (equivalent to ArrayList version)
        playerList.add(new Player(1, 200, "Lotus"));
        playerList.add(new Player(2, 100, "Tenno"));
        playerList.add(new Player(3, 50, "TeshinDax"));

        // get element at index 1
        System.out.println("playerList.get(1): " + playerList.get(1));

        // insert at specific index (index 2)
        playerList.add(2, new Player(10, 750, "Rhino"));

        // remove at specific index (index 2)
        playerList.remove(2);

        // contains() and indexOf()
        System.out.println("Contains Tenno? " +
                playerList.contains(new Player(2, 100, "Tenno")));
        System.out.println("Index of TeshinDax: " +
                playerList.indexOf(new Player(3, 50, "TeshinDax")));

        // demonstrate removeFirst()
        System.out.println("\nRemoving first element: " + playerList.removeFirst());
        System.out.println("Current size: " + playerList.getSize());

        // print remaining players using our own traversal
        System.out.println("\nPlayers in list:");
        playerList.printList();
    }
}
