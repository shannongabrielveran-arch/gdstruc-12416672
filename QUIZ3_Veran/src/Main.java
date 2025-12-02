import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ArrayQueue queue = new ArrayQueue(10);

        int nextPlayerId = 1;
        int gamesMade = 0;

        System.out.println("=== Quiz #3: Matchmaking ===");
        System.out.println("Rules:");
        System.out.println("• Every turn, 1–7 players will join the matchmaking queue.");
        System.out.println("• A game starts when there are at least 5 players in the queue.");
        System.out.println("• Each game uses the first 5 players from the queue (FIFO).");
        System.out.println("• The program ends after 10 games have been made.\n");

        while (gamesMade < 10) {

            System.out.println("Press ENTER to process the next turn...");
            scanner.nextLine();   // pressing enter ends the turn

            // 1–7 players join this turn
            int playersJoining = random.nextInt(7) + 1;
            System.out.println("\n" + playersJoining + " player(s) joined the queue this turn.");

            for (int i = 0; i < playersJoining; i++) {
                int level = random.nextInt(100) + 1;            // random level 1–100
                String name = "Player" + nextPlayerId;          // simple auto-generated name
                Player p = new Player(nextPlayerId, level, name);
                queue.add(p);
                System.out.println("  Queued: " + p);
                nextPlayerId++;
            }

            System.out.println("\nPlayers currently in queue: " + queue.size());
            queue.printQueue();

            // Start as many games as possible this turn
            while (queue.size() >= 5 && gamesMade < 10) {
                gamesMade++;
                System.out.println("\n--- Starting Game #" + gamesMade + " ---");
                System.out.println("Players in this game:");

                for (int i = 0; i < 5; i++) {
                    Player gamePlayer = queue.remove();
                    System.out.println("  " + gamePlayer);
                }

                System.out.println("Game #" + gamesMade + " created!");
                System.out.println("Players left in queue: " + queue.size());
            }

            System.out.println("\n===== End of Turn =====\n");
        }

        System.out.println("10 games have been successfully made. Program terminated.");
    }
}
