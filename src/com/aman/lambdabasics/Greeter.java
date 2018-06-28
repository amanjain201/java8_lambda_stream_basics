package com.aman.lambdabasics;

/**
 *
 * @author amanjain
 */
public class Greeter {
    
    public void greet(Greeting greet){
        greet.perform();
    }
    
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        
        
        Greeting helloGreeting = new HelloGreeting();  // Implementing an interface with a particular instance of class
        
        Greeting lambdaGreeting = () -> System.out.println("\nHello World");  // Implementing an interface by just implemneting a function and 
                                                                            // not by implementing a class
        Greeting innerClassGreeting = new Greeting() {  // lambda is a syntactic sugar expression of this but under the hood both are different
            @Override
            public void perform() {
                System.out.println("\nHello World");
            }
        };
        
        
        
        greeter.greet(helloGreeting);
        greeter.greet(innerClassGreeting);
        greeter.greet(lambdaGreeting);
        
    }
}
