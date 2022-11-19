package main;

import java.util.Random;

public class Shuffle {
    Random rand = new Random();
    int x;

    public int getRandomNumber() {
        return x = rand.nextInt(100) + 1;
    }
}
