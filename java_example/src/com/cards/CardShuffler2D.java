package com.cards;

import java.util.ArrayList;
import java.util.Random;

/**
 * Create deck of cards in a sequence and then shuffle using a random shuffler. Display the shuffled deck
 * Utilize 2D Array for storing a card deck in memory
 */
public class CardShuffler2D {

    static String clubSymbol = "\u2663";
    static String spadeSymbol = "\u2660";
    static String heartSymbol = "\u2665";
    static String diamondSymbol = "\u2666";

    static String faceValue[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static String suit[] = {clubSymbol, diamondSymbol, spadeSymbol, heartSymbol};

    String[][] cardDeck;

    public CardShuffler2D() {
        // 2D array with [No_of_Rows][No_of_Columns]
        cardDeck = new String[4][13];
    }

    String[][] getCardDeck() {
        return cardDeck;
    }

    public static void main(String [] args)
    {
        System.out.println("Ready to shuffle some cards.\n");
        // 1. Create card deck - unshuffled
        // 2. Print unshuffled deck
        // 3. Shuffle the deck
        // 4. Print shuffled deck

        // Create card shuffler with 2D array to store im-memory deck
        CardShuffler2D shuffler2D = new CardShuffler2D();
        shuffler2D.createUnshuffledDeck();
        System.out.println("Printing unshuffled card deck...");
        shuffler2D.printCardDeck(shuffler2D.getCardDeck());
        String shuffledDeck[][] = shuffler2D.shuffleCardDeck();
        System.out.println("\nPrinting shuffled card deck...");
        if (shuffledDeck != null) {
            shuffler2D.printCardDeck(shuffledDeck);
        }
    }

    public void createUnshuffledDeck() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 13; col++) {
                cardDeck[row][col] = faceValue[col] + suit[row];
            }
        }
    }

    public void printCardDeck(String[][] deck) {
        for (int row = 0; row < 4; row = row + 1) {
            for (int col = 0; col < 13; col = col + 1) {
                System.out.print(deck[row][col] + " ");
            }
            System.out.println();
        }
    }


    public String[][] shuffleCardDeck() {
        String[] fullDeck = new String[52];
        int counter = 0;
        int randomInt;
        Random random = new Random();
        ArrayList<Integer> newSequence = new ArrayList<>();

        // 1. Create full deck
        // 2. Shuffle position of card in deck array
        // 3. Shuffle full deck using new sequence positions

        // 1. Create flattened full deck
        for (int row = 0; row < 4; row = row + 1) {
            for (int col = 0; col < 13; col = col + 1) {
                fullDeck[counter] =  cardDeck[row][col];
                counter = counter + 1;
            }
        }

        // 2. Shuffle position of card in array
        counter = 0;
        while (counter < 52) {
            randomInt = random.nextInt(52);

            if(!newSequence.contains(randomInt)) {
                newSequence.add(counter, randomInt);
                counter++;
            }
        }

        // 3. Shuffle full deck using new sequence positions
        for (int i = 0; i < fullDeck.length; i = i + 1) {
            // Swap i'th ele in fullDeck to new pos from newSequence array
            String currentEle = fullDeck[i];
            int newPosition = newSequence.get(i);

            fullDeck[i] = fullDeck[newPosition];
            fullDeck[newPosition] = currentEle;
        }

        return createShuffled2DDeck(fullDeck);
    }

    private String[][] createShuffled2DDeck(String[] fullDeck) {

        int deckCount = 0;
        String[][] shuffledDeck = new String[4][13];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 13; col++) {
                shuffledDeck[row][col] = fullDeck[deckCount];
                deckCount = deckCount + 1;
            }
        }

        return shuffledDeck;
    }
}
