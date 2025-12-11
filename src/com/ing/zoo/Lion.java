package com.ing.zoo;

import com.ing.zoo.interfaces.MeatEaters;

public class Lion extends Animal implements MeatEaters {
    public String name;

    public Lion(String name)
    {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("roooaoaaaaar");
    }


    @Override
    public void eatMeat()
    {
        System.out.println("nomnomnom thx mate");
    }
}
