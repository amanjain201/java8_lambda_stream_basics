package com.aman.lambdabasics.implementations3;

import com.aman.lambdabasics.implementations.Person;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author amanjain
 */
public class StreamsExample1 {
    
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carol", 42),
                new Person("Google", "Chrome", 18),
                new Person("Mozilla", "Firefox", 32),
                new Person("Lnternet", "Explorer", 39));
        
        people.stream()
                .filter(p -> p.getLastName().startsWith("C"))
                .forEach(p -> System.out.println(p.getFirstName()));
              
        
        long count = people.parallelStream()          // parallelStream() doesn't confirm parallel execution, it may return sequential stream also
                .filter(p -> p.getLastName().startsWith("C"))
                .count();
        
        
        System.out.println(people.stream().filter(p -> p.getFirstName().startsWith("L")).findAny().orElse(null));
        
        
        System.out.println("\n\n Count: " + count);
        
        
        /* 
            Streams are an improvement of Collection APIs.
        
            Streams require a source, which is then converted to streams, then some ops and finally a terminal op.
        */
    }
}
