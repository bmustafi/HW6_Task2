package main;

public class BetMore_Game {
    public int pickCard() {
        Shuffle s = new Shuffle();
        return s.getRandomNumber();
    }
}
