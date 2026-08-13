package com.java;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Madlibs {
    private static final List<String> TEMPLATES = Arrays.asList(
            "%s wandered into a %s %s and decided to %s.",
            "Everyone in town knew %s for a %s %s and the way they could %s.",
            "One quiet morning, %s picked up a %s %s and chose to %s the day away.",
            "Legend says %s once used a %s %s to %s the impossible."
    );

    private static final Random RANDOM = new Random();

    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Madlib Generator");

            do{
                String name = prompt(scanner, "Name", "Alex");
                String adjective = prompt(scanner, "Adjective", "mysterious");
                String noun = prompt(scanner, "Noun", "object");
                String verb = prompt(scanner, "Verb (base form)", "explore");

                String template = randomTemplate();
                String madlibStory = String.format(template, capitalise(name), adjective, noun, verb);

                System.out.println();
                System.out.println("Here's your Madlib");
                System.out.println(madlibStory);
                System.out.println();
            }while (confirm(scanner, "Create another madlib story? (y/N): "));

            System.out.println("Hope you enjoy playing!");
        }
    }
    // prompt method
    private static String prompt(Scanner scanner, String label, String defaultValue) {
        System.out.println(label + " [" + defaultValue + "]: ");
        String line = scanner.nextLine();
        if (line == null) return defaultValue;
        line = line.trim();
        return line.isEmpty() ? defaultValue : line;
    }

    // confirm method
    private static boolean confirm(Scanner scanner, String prompt){
        System.out.println(prompt);
        String line = scanner.nextLine();
        if (line == null) return false;
        line = line.trim().toLowerCase();
        return line.equals("y") || line.equals("yes");
    }

}
