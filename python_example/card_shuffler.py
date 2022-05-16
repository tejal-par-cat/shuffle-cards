import constants
import random


class CardShuffler:
    """Create deck of cards in a sequence and then shuffle using a random shuffler. Display the shuffled deck"""
    faceValue = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"]
    suit = [constants.CLUB_SYMBOL, constants.DIAMOND_SYMBOL, constants.SPADE_SYMBOL, constants.HEART_SYMBOL]

    def __init__(self):
        self.cardDeck = [None] * 52

    def create_unshuffled_deck(self):
        n = 0
        for i in range(4):
            for j in range(13):
                print(self.faceValue[j])
                print(self.suit[i])
                print(n)
                self.cardDeck[n] = self.faceValue[j] + self.suit[i]
                n = n + 1

    def print_deck(self):
        n = 0
        for i in range(4):
            for j in range(13):
                print(self.cardDeck[n], end=" ")
                n = n + 1
            print()


if __name__ == "__main__":
    # 1. Create card deck - unshuffled
    # 2. Print unshuffled deck
    # 3. Shuffle the deck
    # 4. Print shuffled deck

    print("Ready to shuffle some cards.")
    shuffler = CardShuffler()
    shuffler.create_unshuffled_deck()
    print("Printing unshuffled card deck...")
    shuffler.print_deck()
