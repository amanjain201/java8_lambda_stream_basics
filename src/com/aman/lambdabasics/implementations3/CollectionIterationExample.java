package com.aman.lambdabasics.implementations3;

import com.aman.lambdabasics.implementations.Person;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author amanjain
 */
public class CollectionIterationExample {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carol", 42),
                new Person("Google", "Chrome", 18),
                new Person("Mozilla", "Firefox", 32),
                new Person("Internet", "Explorer", 39));

        System.out.println("\n 1. Using the normal for loop");
        for (int i = 0; i < people.size(); i++) {                    // External iterators
            System.out.println(people.get(i));
        }

        System.out.println("\n\n 2. Using the for-in loop");
        for (Person p : people) {                                // External iterators
            System.out.println(p);
        }

        System.out.println("\n\n 3. Using the for-each loop with lambda introduced in Java 8");
        people.forEach((p) -> System.out.println(p));           // Internal iterators

        System.out.println("\n\n 4. Using the for-each loop with method inference introduced in Java 8");
        people.forEach(System.out::println);                // Internal iterators

    }

    /*
        Approach 1 & 2 are called external iterators because we control here how do we iterate plus write the business logic.
    
        Approach 3 & 4 are called internal iterators because we let java to iterate how it wants, we don't control the iteration. We just write
        the business logic.
    
        The advantage of approach 3 & 4 is that since iteration is handled by java, it allows for the scope of multi-threaded execution or 
        parallel processing. Whereas incase of 1 & 2, its always sequential approch.
     */
}
