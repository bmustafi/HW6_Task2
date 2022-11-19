package main;
import java.util.Scanner;

public class Game_Chair {
    BetMore_Game bet = new BetMore_Game();
    Player computer = new Player(bet.pickCard());
    Player player = new Player(bet.pickCard());
    Scanner input = new Scanner(System.in);
    int rerolls = 5;

    public static void main(String[] args) {
        Game_Chair chair = new Game_Chair();
        chair.start();
    }

    public void start() {
        System.out.println("Welcome to BetMore!");
        System.out.println("-------------------------");
        System.out.println("Computer picked a card.");
        System.out.println("Enter 1 to start playing:");

        int userInput = input.nextInt();
        if (userInput == 1) {
            play();
        } else {
            System.out.println("Invalid input. Please restart the game.");
        }
    }

    public void play() {
        System.out.println("You picked " + player.getCard() + ". You can reroll your card " + rerolls + " times.");

        while (rerolls >= 0) {
            if (rerolls == 0) {
                findWinner(computer, player);
                break;
            }

            System.out.println("Press 0 to stay or press 1 to reroll:");
            int userInput = input.nextInt();

            if (userInput == 1) {
                int newCard = bet.pickCard();
                player.setCard(newCard);
                rerolls--;
                System.out.println("Your new card is " + player.getCard() + ". You have " + rerolls + " rerolls left.");
            } else if (userInput == 0) {
                findWinner(computer, player);
                break;
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    public void findWinner(Player computer, Player player) {
        System.out.println("----- RESULTS -----");
        System.out.println("Computer picked: " + computer.getCard());
        System.out.println("You picked: " + player.getCard());

        if (computer.getCard() > player.getCard()) {
            System.out.println("You lost!");
        } else if (computer.getCard() < player.getCard()) {
            System.out.println("You won!");
        } else {
            System.out.println("The game ended in a draw!");
        }
    }
}
