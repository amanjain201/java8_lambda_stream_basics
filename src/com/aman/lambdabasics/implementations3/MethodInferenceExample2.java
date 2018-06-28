package com.aman.lambdabasics.implementations3;

import com.aman.lambdabasics.implementations.Person;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author amanjain
 */
public class MethodInferenceExample2 {
    
    
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carol", 42),
                new Person("Google", "Chrome", 18),
                new Person("Mozilla", "Firefox", 32),
                new Person("Internet", "Explorer", 39));


        System.out.println("\nPrinting all people ");
        performConditionally(people, p -> true, p -> System.out.println(p));
        
        
        /*
            First of all, a method reference can't be used for any method. They can only be used to replace a single-method lambda expression.
        
            Instead of using
            AN ANONYMOUS CLASS
            you can use
            A LAMBDA EXPRESSION
            And if this just calls one method, you can use
            A METHOD REFERENCE
        */
        
        System.out.println("\n\nPrinting all people using Method Inference");
        performConditionally(people, p -> true, System.out::println); // (p) -> method(p)
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

