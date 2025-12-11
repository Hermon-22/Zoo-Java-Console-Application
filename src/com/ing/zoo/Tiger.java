package com.ing.zoo;

import com.ing.zoo.interfaces.LeavesEaters;
import com.ing.zoo.interfaces.MeatEaters;
import com.ing.zoo.interfaces.TrickPerformers;

import java.util.Random;

public class Tiger extends Animal implements MeatEaters, TrickPerformers {
    public String name;
    public String trick;

    public Tiger(String name)
    {
        super(name);
    }

    @Override
    public void sayHello()
    {
        System.out.println("rraaarww");
    }

    @Override
    public void eatMeat() {
        System.out.println("nomnomnom oink wubalubadubdub");
    }

    public void performTrick()
    {
        Random random = new Random();
        int rnd = random.nextInt(2);
        if(rnd == 0)
        {
            trick = "jumps in tree";
        }
        else
        {
            trick = "scratches ears";
        }
        System.out.println(trick);
    }
}
