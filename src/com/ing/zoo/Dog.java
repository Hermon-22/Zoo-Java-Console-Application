package com.ing.zoo;

import com.ing.zoo.interfaces.MeatEaters;

public class Dog extends Animal implements MeatEaters {
    public String name;

    public Dog(String name)
    {
        super(name);
    }
    @Override
    public void sayHello() {
        System.out.println("Woef woef");
    }

    @Override
    public void eatMeat() {
        System.out.println("nom nom thanks boss!");
    }
}
