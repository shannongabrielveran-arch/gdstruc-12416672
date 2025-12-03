import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Player deck (STACK using array + selection sort)
        CardStack playerDeck = createPlayerDeck();
        CardStack discardedPile = new CardStack(30);

        // Player hand uses a List
        List<Card> playerHand = new ArrayList<>();

        int round = 1;
        System.out.println("=== Card Game Simulator ===");
        System.out.println("The program will end when the player deck is emptied.\n");

        while (!playerDeck.isEmpty()) {
            System.out.println("----- Round " + round + " -----");

            int commandType = random.nextInt(3); // 0=draw, 1=discard, 2=get from discarded

            switch (commandType) {
                case 0:
                    // Draw x cards (1–5)
                    int drawCount = random.nextInt(5) + 1;
                    System.out.println("Command: Draw " + drawCount + " card(s).");
                    for (int i = 0; i < drawCount && !playerDeck.isEmpty(); i++) {
                        Card drawn = playerDeck.pop();
                        if (drawn != null) {
                            playerHand.add(drawn);
                        }
                    }
                    break;

                case 1:
                    // Discard x cards (1–5, but not more than hand size)
                    int discardCount = random.nextInt(5) + 1;
                    if (playerHand.isEmpty()) {
                        System.out.println("Command: Discard " + discardCount
                                + " card(s) (but hand is empty).");
                    } else {
                        discardCount = Math.min(discardCount, playerHand.size());
                        System.out.println("Command: Discard " + discardCount + " card(s).");
                        for (int i = 0; i < discardCount; i++) {
                            // Discard from the end of the list
                            Card removed = playerHand.remove(playerHand.size() - 1);
                            discardedPile.push(removed);
                        }
                    }
                    break;

                case 2:
                    // Get x cards from discarded pile (1–5)
                    int getCount = random.nextInt(5) + 1;
                    if (discardedPile.isEmpty()) {
                        System.out.println("Command: Get " + getCount
                                + " card(s) from discarded pile (but discard pile is empty).");
                    } else {
                        getCount = Math.min(getCount, discardedPile.size());
                        System.out.println("Command: Get " + getCount
                                + " card(s) from discarded pile.");
                        for (int i = 0; i < getCount && !discardedPile.isEmpty(); i++) {
                            Card recovered = discardedPile.pop();
                            if (recovered != null) {
                                playerHand.add(recovered);
                            }
                        }
                    }
                    break;

                default:
                    break;
            }

            // Sort the player's hand using Bubble Sort (arrays + list)
            sortHandWithBubbleSort(playerHand);

            // Show status after the round
            printStatus(playerHand, playerDeck, discardedPile);

            System.out.println("Press Enter to end the turn and continue...");
            scanner.nextLine();
            round++;
        }

        System.out.println("\nThe player deck is empty. Program has ended.");
    }

    // Creates a 30-card deck. Uses arrays + SELECTION SORT.
    private static CardStack createPlayerDeck() {
        String[] cardNames = {
                "Dragon", "Knight", "Wizard", "Goblin", "Orc", "Elf", "Dwarf", "Angel", "Demon", "Beast",
                "Rogue", "Paladin", "Archer", "Cleric", "Bard", "Monk", "Necromancer", "Samurai", "Ninja", "Pirate",
                "Robot", "Alien", "Soldier", "Mage", "Titan", "Golem", "Vampire", "Werewolf", "Slime", "Spirit"
        };

        // Array of Card objects
        Card[] cardsArray = new Card[cardNames.length];
        for (int i = 0; i < cardNames.length; i++) {
            cardsArray[i] = new Card(cardNames[i]);
        }

        // Selection sort by name (demonstrates selection sort + arrays)
        selectionSortByName(cardsArray);

        // Push cards into the stack (top of stack = last element of sorted array)
        CardStack deck = new CardStack(cardsArray.length);
        for (Card card : cardsArray) {
            deck.push(card);
        }

        return deck;
    }

    // Bubble sort using arrays, but source is a List.
    private static void sortHandWithBubbleSort(List<Card> hand) {
        if (hand.size() < 2) {
            return;
        }

        Card[] temp = hand.toArray(new Card[0]);
        bubbleSortByName(temp);

        hand.clear();
        Collections.addAll(hand, temp);
    }

    // BUBBLE SORT (ascending by card name)
    private static void bubbleSortByName(Card[] arr) {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--) {
            for (int i = 0; i < lastSortedIndex; i++) {
                if (arr[i].getName().compareTo(arr[i + 1].getName()) > 0) {
                    Card temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    // SELECTION SORT (descending by card name, just for variety)
    private static void selectionSortByName(Card[] arr) {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--) {
            int largestIndex = 0;
            for (int i = 1; i <= lastSortedIndex; i++) {
                if (arr[i].getName().compareTo(arr[largestIndex].getName()) > 0) {
                    largestIndex = i;
                }
            }
            Card temp = arr[largestIndex];
            arr[largestIndex] = arr[lastSortedIndex];
            arr[lastSortedIndex] = temp;
        }
    }

    private static void printStatus(List<Card> hand, CardStack deck, CardStack discarded) {
        System.out.println("\nPlayer's current hand:");
        if (hand.isEmpty()) {
            System.out.println("(no cards in hand)");
        } else {
            for (Card c : hand) {
                System.out.println("- " + c);
            }
        }

        System.out.println("Remaining cards in player deck: " + deck.size());
        System.out.println("Number of cards in discarded pile: " + discarded.size());
        System.out.println();
    }
}
