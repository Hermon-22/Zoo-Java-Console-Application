package com.ing.zoo;

import com.ing.zoo.interfaces.LeavesEaters;

public class Zebra extends Animal implements LeavesEaters {
    public Zebra(String name)
    {
        super(name);
    }

    @Override
    public void sayHello()
    {
        System.out.println("zebra zebra");
    }

    @Override
    public void eatLeaves() {
        System.out.println("munch munch zank yee bra");
    }
}
