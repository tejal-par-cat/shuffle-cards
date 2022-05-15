package com.cards;

import java.util.ArrayList;
import java.util.Random;

/**
 * Create deck of cards in a sequence and then shuffle using a random shuffler. Display the shuffled deck
 * Store card deck in memory
 */
public class CardShuffler {

    static String clubSymbol = "\u2663";
    static String spadeSymbol = "\u2660";
    static String heartSymbol = "\u2665";
    static String diamondSymbol = "\u2666";

    static String faceValue[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static String suit[] = {clubSymbol, diamondSymbol, spadeSymbol, heartSymbol};

    public static void main(String [] args)
    {
        System.out.println("Ready to shuffle some cards.\n");

        // 1. Create card deck - unshuffled
        // 2. Print unshuffled deck
        // 3. Shuffle the deck
        // 4. Print shuffled deck

        String cardDeck[] = createUnshuffledDeck();
        System.out.println("Printing unshuffled card deck...");
        printCardDeck(cardDeck);
        System.out.println("\nPrinting shuffled card deck...");
        shuffleCardDeck(cardDeck);
    }

    private static String[] createUnshuffledDeck() {
        String deck[] = new String[52];
        int n = 0;

        for (int i = 0; i < 4; i = i + 1)
        {
            for (int j = 0; j < 13; j = j + 1) {
                deck[n] = faceValue[j] + suit[i];
                n++;
            }
        }
        return deck;
    }

    private static void printCardDeck(String cardDeck[]) {
        int n = 0;
        for (int i = 0; i < 4; i = i + 1)
        {
            for (int j = 0; j < 13; j = j + 1) {
                System.out.print(cardDeck[n] + " ");
                n++;
            }
            System.out.println();
        }
    }

    private static void shuffleCardDeck(String origCardDeck[]) {
        // 0 --> 1♣
        // 1 --> 2♣
        //[1♣ 2♣ 3♣ 4♣ 5♣ 6♣ 7♣ 8♣ 9♣ 10♣ J♣ Q♣ K♣ 1♦ 2♦ 3♦ 4♦ 5♦ 6♦ 7♦ 8♦ 9♦ 10♦ J♦ Q♦ K♦ 1♠ 2♠ 3♠ 4♠ 5♠ 6♠ 7♠ 8♠ 9♠ 10♠ J♠ Q♠ K♠ 1♥ 2♥ 3♥ 4♥ 5♥ 6♥ 7♥ 8♥ 9♥ 10♥ J♥ Q♥ K♥ ]

        // 1. Generate random index
        // 2. Create new array and copy element from orig array into new index pos

        // 1. Generate random index
        // generate 52 numbers using nextInt
        // numbers should be unique

        Random random = new Random();
        ArrayList<Integer> shuffleOrder = new ArrayList<>();
        // 0 -> Ele1
        // 1 -> Ele2

        for (int i = 0; i < 52; i++) {
            boolean isNumberStored = false;

            while (isNumberStored == false) {
                int randomInt = random.nextInt(52);
                if (shuffleOrder.contains(randomInt) == false) {
                    shuffleOrder.add(randomInt);
                    isNumberStored = true;
                }
            }
        }

        // 2. Create new array and copy element from orig array into new index pos

        // Orig = origCardDeck[]
        //Original Array
        // 0 -> 1♣
        // 1 -> 2♣
        //[1♣ 2♣ 3♣ 4♣ 5♣ 6♣ 7♣ 8♣ 9♣ 10♣ J♣ Q♣ K♣ 1♦ 2♦ 3♦ 4♦ 5♦ 6♦ 7♦ 8♦ 9♦ 10♦ J♦ Q♦ K♦ 1♠ 2♠ 3♠ 4♠ 5♠ 6♠ 7♠ 8♠ 9♠ 10♠ J♠ Q♠ K♠ 1♥ 2♥ 3♥ 4♥ 5♥ 6♥ 7♥ 8♥ 9♥ 10♥ J♥ Q♥ K♥ ]

        // ArrayList with new index order
        // 0th pos -> 15
        // 1st pos -> 13

        // Pick ele at 15th pos from orig array -> copy to new array 0th pos
        // New array which will store shuffled com.cards
        String shuffledCardDeck[] = new String[52];
        for (int i = 0; i < 52; i++) {
            int newIndexPos = shuffleOrder.get(i);
            // assign ele from ith pos in orig array to newIndexPos in shuffledCardDeck
            shuffledCardDeck[i] = origCardDeck[newIndexPos];
        }

        printCardDeck(shuffledCardDeck);

    }

}
