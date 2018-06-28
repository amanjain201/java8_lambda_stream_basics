package com.aman.lambdabasics.performancetesting;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author amanjain
 */
public class StreamLazinessTest {

    /**
     * Intermediate operations just create another stream, but won't perform any processing until the terminal operation is called. 
     * Once the terminal operation is called, traversal of streams begins and the associated function is applied one by one. 
     * Intermediate operations are lazy operations, so Streams supports laziness. *
     */
    
    /**
     * Employee class *
     */
    static class Employee {

        int id;
        String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List< Employee> employees = new ArrayList<>();
        /**
         * Creating the employee list *
         */
        for (int i = 1; i < 100000; i++) {
            employees.add(new StreamLazinessTest.Employee(i, "name_" + i));
        }
        /**
         * Only Intermediate Operations; it will just create another streams and
         * will not perform any operations *
         */
        Stream< String> employeeNameStreams = employees.parallelStream().filter(employee -> employee.id % 2 == 0)
                .map(employee -> {
                    System.out.println("In Map - " + employee.getName());
                    return employee.getName();
                });
        /**
         * Adding some delay to make sure nothing has happen till now *
         */
        TimeUnit.SECONDS.sleep(2);
        System.out.println("2 sec");
        /**
         * Terminal operation on the stream and it will invoke the Intermediate
         * Operations filter and map *
         */
        employeeNameStreams.collect(Collectors.toList());
    }
}
