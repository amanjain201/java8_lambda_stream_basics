package com.aman.lambdabasics.performancetesting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author amanjain
 */
public class StreamShortCircuitTest {

    /**
     * Short-circuiting will terminate the processing once condition met. *
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

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List< Employee> employees = new ArrayList<>();
        for (int i = 1; i < 10000000; i++) {
            employees.add(new StreamShortCircuitTest.Employee(i, "name_" + i));
        }
        /**
         * Only Intermediate Operations; it will just create another streams and
         * will not perform any operations * There are a number of
         * short-circuiting operations available. For e.g. anyMatch, allMatch,
         * findFirst, findAny, limit, etc.*
         */
        Stream< String> employeeNameStreams = employees.stream().filter(e -> e.getId() % 2 == 0)
                .map(employee -> {
                    System.out.println("In Map - " + employee.getName());
                    return employee.getName();
                });
        long streamStartTime = System.currentTimeMillis();
        /**
         * Terminal operation with short-circuit operation: limit *
         */
        employeeNameStreams.limit(100).collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - streamStartTime);
    }
}
