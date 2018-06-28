package com.aman.lambdabasics.implementations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author amanjain
 */
public class Implementation1java8Inbuilt {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carol", 42),
                new Person("Google", "Chrome", 18),
                new Person("Mozilla", "Firefox", 32),
                new Person("Internet", "Explorer", 39));

        // Step 1: Sort list by last name
        Collections.sort(people, (o1, o2)-> o1.getLastName().compareTo(o2.getLastName()));

        // Step 2: Create a method that prints all elements in the list
        System.out.println("\nPrinting all people ");
        printConditionally(people, p -> true);

        // Step 3: Create a method that prints all people with last name starting with C
        System.out.println("\nPrinting all people with last name starting with C");
        printConditionally(people, p -> p.getLastName().startsWith("C"));

        System.out.println("\nPrinting all people with first name starting with C");
        printConditionally(people, p -> p.getLastName().startsWith("C"));
    }

    // printAll can be replaced by printConditionally so commenting it out
//    private static void printAll(List<Person> people) {
//        for (Person p : people) {
//            System.out.println(p);
//        }
//    }

    private static void printConditionally(List<Person> people, Predicate<Person> condition) {
        for (Person p : people) {
            if (condition.test(p)) {
                System.out.println(p);
            }
        }
    }

}

