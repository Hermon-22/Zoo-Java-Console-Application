package com.ing.zoo;

import com.ing.zoo.interfaces.LeavesEaters;

public class Hippo extends Animal implements LeavesEaters {
    public String name;

    public Hippo(String name)
    {
        super(name);
    }

    @Override
    public void sayHello()
    {
        System.out.println("splash");
    }

    @Override
    public void eatLeaves() {
        System.out.println("munch munch lovely");
    }

}
