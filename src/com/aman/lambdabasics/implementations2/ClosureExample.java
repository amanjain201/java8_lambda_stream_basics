package com.aman.lambdabasics.implementations2;

/**
 *
 * @author amanjain
 */
public class ClosureExample {

    public static void main(String[] args) {
        int a=10;
        int b=20; // In java 8, even if final is not given, compiler considers it effectively final, however it keeps an watch if it is changed and shows 
                  // error. 
        doProcess(a, i -> System.out.println(i + b));
//        b=30;
    }
    
    public static void doProcess(int a, Process p){
        p.process(a);
    }
}

interface Process {

    void process(int i);
}
