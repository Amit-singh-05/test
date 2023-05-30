package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import card.ActionCard;
import card.Card;
import card.ColoredCard;
import card.action.Action;
import card.deck.Deck;
import player.Player;

public class Game {
	 private List<Player> players;
	    private Deck deck;
	    private Card currentCard;

	    public Game() {
	        players = new ArrayList<>();
	        deck = new Deck();
	        currentCard = null;
	    }

	    public void addPlayer(Player player) {
	        players.add(player);
	    }

	    public void startGame() {
	        deck.shuffle();
	        distributeCards();

	        // First card from the deck will be the current card 
	        currentCard = deck.drawCard();

	        // Until anyone player wins the game, game Will be continued
	        boolean gameOver = false;
	        Player currentPlayer = players.get(0);

	        while (!gameOver) {
	            System.out.println("Current card: " + currentCard);

	            // Check if the move made by the player is valid or not 
	            boolean hasValidMove = hasValidMove(currentPlayer);

	            if (hasValidMove) {
	                //Hey details of the player whose turn this one is and option To pick one card with which he wants to go for this turn 
	                System.out.println("Current player: " + currentPlayer.getName());
	                System.out.println("Your hand: " + currentPlayer.getHand());
	                System.out.println("Enter the index of the card you want to play (or -1 to draw):");

	                int cardIndex = getPlayerInput();

	                if (cardIndex == -1) {
	                    // Draw a card
	                    Card drawnCard = deck.drawCard();
	                    currentPlayer.addCard(drawnCard);
	                    System.out.println("You drew: " + drawnCard);
	                } else {
	                    // Play with the selected card 
	                    Card selectedCard = currentPlayer.getHand().get(cardIndex);

	                    if (isValidMove(selectedCard)) {
	                        currentPlayer.removeCard(selectedCard);
	                        currentCard = selectedCard;
	                        System.out.println("You played: " + selectedCard);

	                        // Check if the player won
	                        if (currentPlayer.getHand().isEmpty()) {
	                            gameOver = true;
	                            System.out.println(currentPlayer.getName() + " wins!");
	                        }

	                        // Apply the action of the card
	                        applyAction(selectedCard);
	                    } else {
	                        System.out.println("Invalid move. Try again.");
	                    }
	                }
	            } else {
	                // The current player cannot make a move, they must draw a card
	                Card drawnCard = deck.drawCard();
	                currentPlayer.addCard(drawnCard);
	                System.out.println(currentPlayer.getName() + " drew a card: " + drawnCard);

	                // Check if the player can play the drawn card
	                if (isValidMove(drawnCard)) {
	                    currentPlayer.removeCard(drawnCard);
	                    currentCard = drawnCard;
	                    System.out.println(currentPlayer.getName() + " played: " + drawnCard);

	                    // Check if the player has won
	                    if (currentPlayer.getHand().isEmpty()) {
	                        gameOver = true;
	                        System.out.println(currentPlayer.getName() + " wins!");
	                    }

	                    // Apply the action of the card
	                    applyAction(drawnCard);
	                }
	            }

	            // it's turn off next player 
	            currentPlayer = getNextPlayer(currentPlayer);
	        }
	    }

	    private void distributeCards() {
	        // Each player should receive 7 cards.
	        deck.dealCards(players, 7);
	    }

	    private boolean hasValidMove(Player player) {
	        // Check if the player has a valid move (card with the same color, value, or wild card)
	        for (Card card : player.getHand()) {
	            if (card instanceof ColoredCard) {
	                ColoredCard coloredCard = (ColoredCard) card;
	                if (coloredCard.getColor() == currentCard.getColor()) {
	                    return true;
	                }
	            } else if (card instanceof ActionCard) {
	                ActionCard actionCard = (ActionCard) card;
	                if (actionCard.getColor() == currentCard.getColor() || actionCard.getAction() == Action.WILD) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

	    private boolean isValidMove(Card card) {
	        if (card instanceof ColoredCard) {
	            ColoredCard coloredCard = (ColoredCard) card;
	            return coloredCard.getColor() == currentCard.getColor();
	        } else if (card instanceof ActionCard) {
	            ActionCard actionCard = (ActionCard) card;
	            return actionCard.getColor() == currentCard.getColor() || actionCard.getColor() == null;
	        }
	        return false;
	    }

	    private void applyAction(Card card) {
	        if (card instanceof ActionCard) {
	            Action action = ((ActionCard) card).getAction();
	            switch (action) {
	                case SKIP:
	                    Player nextPlayer = getNextPlayer(players.get(0));
	                    System.out.println(nextPlayer.getName() + " was skipped.");
	                    break;
	                case REVERSE:
	                    System.out.println("The direction of play has been reversed.");
	                    Collections.reverse(players);
	                    break;
	                case DRAW_TWO:
	                    nextPlayer = getNextPlayer(players.get(0));
	                    drawCards(nextPlayer, 2);
	                    System.out.println(nextPlayer.getName() + " drew 2 cards.");
	                    break;
	                case DRAW_FOUR:
	                    nextPlayer = getNextPlayer(players.get(0));
	                    drawCards(nextPlayer, 4);
	                    System.out.println(nextPlayer.getName() + " drew 4 cards.");
	                    break;
	                case WILD:
	                    break;
	            }
	        }
	    }

	    private Player getNextPlayer(Player currentPlayer) {
	        int currentIndex = players.indexOf(currentPlayer);
	        int nextIndex = (currentIndex + 1) % players.size();
	        return players.get(nextIndex);
	    }

	    private void drawCards(Player player, int numCards) {
	        for (int i = 0; i < numCards; i++) {
	            Card drawnCard = deck.drawCard();
	            player.addCard(drawnCard);
	        }
	    }

	    private int getPlayerInput() {
	        Scanner scanner = new Scanner(System.in);
	        return scanner.nextInt();
	    }
}
