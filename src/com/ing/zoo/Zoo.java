package com.ing.zoo;

import com.ing.zoo.interfaces.LeavesEaters;
import com.ing.zoo.interfaces.MeatEaters;
import com.ing.zoo.interfaces.TrickPerformers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class Zoo {
    public static void main(String[] args)
    {
        String[] commands = new String[4];
        commands[0] = "hello";
        commands[1] = "give leaves";
        commands[2] = "give meat";
        commands[3] = "perform trick";

        List<Animal> animals = new ArrayList<>();
        animals.add(new Lion("henk"));
        animals.add(new Hippo("elsa"));
        animals.add(new Pig("dora"));
        animals.add(new Tiger("wally"));
        animals.add(new Zebra("marty"));
        animals.add(new Dog("bob"));
        animals.add(new Elephant("dumbo"));

        System.out.println("Welkom bij de Zoo!");
        System.out.println("Beschikbare commando's: hello [naam], give leaves [naam], give meat [naam], perform trick [naam]");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Voer uw command in: ");

        String input = scanner.nextLine();
        String[] parts = input.split(" "); // splitting commands

        String command = parts[0].toLowerCase();
        String name = parts.length > 1 ? parts[1] : null;

        switch (command) {
            case "hello":
                if (name == null) {
                    animals.forEach(a -> {
                        System.out.print(a.getName().toUpperCase() + ": ");
                        a.sayHello();
                    });
                } else {
                    Optional<Animal> found = animals.stream()
                            .filter(a -> a.getName().equalsIgnoreCase(name))
                            .findFirst();

                    if (found.isPresent()) {
                        found.get().sayHello();
                    } else {
                        System.out.println("Geen dier gevonden met de naam: " + name);
                    }
                }
                break;

            case "give":
                if (parts.length < 2) {
                    System.out.println("Usage: give [leaves|meat] [naam]");
                    break;
                }

                String type = parts[1];
                String target = parts.length == 3 ? parts[2] : null;

                switch (type) {
                    case "leaves":
                        if (target == null) {
                            // Give leaves to ALL leaf-eaters
                            animals.stream()
                                    .filter(a -> a instanceof LeavesEaters)
                                    .forEach(a -> {
                                        System.out.print(a.getName().toUpperCase() + " -> ");
                                        ((LeavesEaters) a).eatLeaves();
                                    });
                        }
                        else {
                            // Give leaves to ONE animal
                            Optional<Animal> leafAnimal = animals.stream()
                                    .filter(a -> a.getName().equalsIgnoreCase(target))
                                    .filter(a -> a instanceof LeavesEaters)
                                    .findFirst();

                            if (leafAnimal.isPresent()) {
                                ((LeavesEaters) leafAnimal.get()).eatLeaves();
                            } else {
                                System.out.println(target + " eet geen bladeren of Geen dier gevonden met de naam: " + target);
                            }
                        }
                        break;

                    case "meat":
                        if (target == null) {
                            animals.stream()
                                    .filter(a -> a instanceof MeatEaters)
                                    .forEach(a -> {
                                            System.out.print(a.getName().toUpperCase() + " -> ");
                                            ((MeatEaters) a).eatMeat();
                                    });
                                    }
                        else {
                            Optional<Animal> meatAnimal = animals.stream()
                                    .filter(a -> a.getName().equalsIgnoreCase(target))
                                    .filter(a -> a instanceof MeatEaters)
                                    .findFirst();

                            if (meatAnimal.isPresent()) {
                                ((MeatEaters) meatAnimal.get()).eatMeat();
                            } else {
                                System.out.println(target + " eet geen vlees of Geen dier gevonden met de naam: " + target);
                            }
                        }
                        break;

                    default:
                        System.out.println("Onbekende eten: " + type);
                }
                break;


            case "perform":
                if (parts.length < 2 || !parts[1].equals("trick")) {
                    System.out.println("Unknown command");
                    break;
                }

                // perform trick for all animals
                if (parts.length == 2) {
                    animals.stream()
                            .filter(a -> a instanceof TrickPerformers)
                            .forEach(a -> {
                                System.out.print(a.getName().toUpperCase() + " -> ");
                                    ((TrickPerformers) a).performTrick();
                            });
                    break;
                }

                // perform trick <name>
                String targetName = parts[2];

                Optional<Animal> found = animals.stream()
                        .filter(a -> a.getName().equalsIgnoreCase(targetName))
                        .findFirst();

                if (!found.isPresent()) {
                    System.out.println("Dier niet gevonden: " + targetName);
                    break;
                }

                Animal animal = found.get();

                if (!(animal instanceof TrickPerformers)) {
                    System.out.println(animal.getName() + " kan geen trucjes uitvoeren!");
                    break;
                }

                ((TrickPerformers) animal).performTrick();
                break;
            default:
                System.out.println("onbekende command: " + command);
        }
    }
}