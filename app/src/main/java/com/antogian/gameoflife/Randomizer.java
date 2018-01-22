package com.antogian.gameoflife;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Tony on 19/1/2018.
 */

public class Randomizer
{
    public static int getRandomInteger(int min, int max)
    {
        int random;
        random = ThreadLocalRandom.current().nextInt(min, max + 1);
        return random;
    }
}
