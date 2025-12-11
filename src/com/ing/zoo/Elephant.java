package com.ing.zoo;

import com.ing.zoo.interfaces.LeavesEaters;
import com.ing.zoo.interfaces.TrickPerformers;

import java.util.Random;

public class Elephant extends Animal implements LeavesEaters, TrickPerformers {
    public Elephant(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("PRRRRROOOOT");
    }

    @Override
    public void eatLeaves() {
        System.out.println("munch munch… tasty greens.");
    }

    @Override
    public void performTrick() {
        Random random = new Random();
        int r = random.nextInt(2);
        if (r == 0) {
            System.out.println("sprays water everywhere!");
        } else {
            System.out.println("balances on one leg!");
        }
    }
}
