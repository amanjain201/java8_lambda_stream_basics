package com.aman.lambdabasics.implementations2;

import com.aman.lambdabasics.implementations.Person;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author amanjain
 */
public class Implementation2Java8FunctionPackageInterfaces {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carol", 42),
                new Person("Google", "Chrome", 18),
                new Person("Mozilla", "Firefox", 32),
                new Person("Internet", "Explorer", 39));

        // Step 1: Sort list by last name
        Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

        // Step 2: Create a method that prints all elements in the list
        System.out.println("\nPrinting all people ");
        performConditionally(people, p -> true, p -> System.out.println(p));

        // Step 3: Create a method that prints all people with last name starting with C
        System.out.println("\nPrinting all people with last name starting with C");
        performConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));

        System.out.println("\nPrinting all people with first name starting with C");
        performConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p.getFirstName()));
    }

    // Leveraging the inbuilt functional interfaces Predicate and Consumer from java.util.function package, commonly used interfaces will be available.
    
    private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }
}
