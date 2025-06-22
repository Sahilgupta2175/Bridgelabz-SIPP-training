import java.util.Scanner;

class Q10_DeckOfCards {

    static String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
    static String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
    };

    public static String[] createDeck() {
        String[] deck = new String[52];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int rand = i + (int) (Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
    }

    public static String[][] distribute(String[] deck, int players, int cardsPerPlayer) {
        if (players * cardsPerPlayer > deck.length)
            return null;
        String[][] hands = new String[players][cardsPerPlayer];
        int index = 0;
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                hands[i][j] = deck[index++];
            }
        }
        return hands;
    }

    public static void displayHands(String[][] hands) {
        for (int i = 0; i < hands.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            for (String card : hands[i]) {
                System.out.print(card + " | ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int players = sc.nextInt();
        System.out.print("Enter number of cards per player: ");
        int cards = sc.nextInt();

        String[] deck = createDeck();
        shuffleDeck(deck);
        String[][] hands = distribute(deck, players, cards);

        if (hands == null) {
            System.out.println("Not enough cards in the deck!");
        } else {
            displayHands(hands);
        }

        sc.close();
    }
}
