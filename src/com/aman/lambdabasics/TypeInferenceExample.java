package com.aman.lambdabasics;

/**
 *
 * @author amanjain
 */
public class TypeInferenceExample {
    
    public static void main(String[] args) {
        StringLengthLambda myLambda = (String s) -> s.length();  // return is not required for a single line statement in lambda
        System.out.println("Exp 1 length : " + myLambda.getLength("Hello Lambda"));
        
        myLambda = (s) -> s.length(); // Type of the argument can be done away because of interface type StringLengthLambda which maps accordingly
        System.out.println("Exp 2 length : " + myLambda.getLength("Hello Lambda"));
        
        myLambda = s -> s.length(); // If only 1 argument is there, then parenthesis aren't required. This is the most compact form.
        System.out.println("Exp 3 length : " + myLambda.getLength("Hello Lambda"));
        
        printLambda(s -> s.length());
        
    }
    
    public static void printLambda(StringLengthLambda l){
        System.out.println("Exp 4 length : " + l.getLength("Hello Lambda"));
    }
    
    interface StringLengthLambda {
        int getLength(String s);
    }
}
