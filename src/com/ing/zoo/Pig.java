package com.ing.zoo;

import com.ing.zoo.interfaces.LeavesEaters;
import com.ing.zoo.interfaces.MeatEaters;
import com.ing.zoo.interfaces.TrickPerformers;

import java.util.Random;

public class Pig extends Animal implements MeatEaters, LeavesEaters, TrickPerformers {

    public Pig(String name) {
        super(name);
    }

    public void sayHello()
    {
        System.out.println("splash");
    }

    @Override
    public void eatLeaves()
    {
        System.out.println( "munch munch oink");
    }

    @Override
    public void eatMeat()
    {
        System.out.println("nomnomnom oink thx");
    }

    @Override
    public void performTrick()
    {
        Random random = new Random();
        int rnd = random.nextInt(2);
        String trick;
        if(rnd == 0)
        {
            trick = "rolls in the mud";
        }
        else
        {
            trick = "runs in circles";
        }
        System.out.println(trick);
    }
}
