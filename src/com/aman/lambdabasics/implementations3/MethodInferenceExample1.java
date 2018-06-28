package com.aman.lambdabasics.implementations3;

/**
 *
 * @author amanjain
 */
public class MethodInferenceExample1 {
    
    public static void main(String[] args) {
        
        Thread t = new Thread(MethodInferenceExample1::printMessage); // () -> method();
        // MethodInferenceExample1::printMessage === () -> printMessage()
        t.start();
    }
    
    public static void printMessage(){
        System.out.println("Hello!!");
    }
}
