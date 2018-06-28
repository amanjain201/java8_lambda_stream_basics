package com.aman.lambdabasics.implementations2;

import java.util.function.BiConsumer;

/**
 *
 * @author amanjain
 */
public class ExceptionHandlingInLambda {

    public static void main(String[] args) {
        int[] someNumbers = {1, 2, 3, 4};
        int key = 0;

        // We can apply try catch in lambda exp. itself, but then it won't look elegant enough. What we will do is create wrapper lambda to handle specific
        // exceptions
        process(someNumbers, key, wrapperLambda((v,k) -> System.out.println(v/k)));
    }

    private static void process(int[] someNumbers, int key, BiConsumer<Integer,Integer> consumer) {
        for (int i : someNumbers) {
            // We can catch specific exception here, but if any other exception is thrown it won't be able to catch as we may not know the thrown exception
            consumer.accept(i, key);
        }
    }
    
    // We can make this a generic wrapper for BiConsumer that accepts 2 types
    private static BiConsumer<Integer,Integer> wrapperLambda(BiConsumer<Integer,Integer> consumer) {
        return (v,k) -> {
           try {
               consumer.accept(v, k);
           } catch (ArithmeticException ex) {
               System.out.println("Exception handled in the wrapper");
           }
        };
    }
}
