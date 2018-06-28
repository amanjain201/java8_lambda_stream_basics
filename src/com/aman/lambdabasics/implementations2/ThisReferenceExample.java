package com.aman.lambdabasics.implementations2;

/**
 *
 * @author amanjain
 */
public class ThisReferenceExample {

    public void doProcess(int i, Process p) {
        p.process(i);
    }

    public void execute() {
        // this === ?
        doProcess(10, i -> {
            System.out.println("The value of i is " + i);
            System.out.println(this);
        });
    }

    public static void main(String[] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

//        System.out.println(this);

        // 'this' meaning when using anonymous inner class
        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println("The value of i is " + i);
                System.out.println(this);

            }

            public String toString() {
                return "This is anonymous inner class";
            }
        });

        //'this' meaning when using lambda
        // shows the same error as line 16 when uncommented. That means that 'this' is not overridden in lambda exp. as in anonymous inner class 
//        thisReferenceExample.doProcess(10, i -> {
//           System.out.println("The value of i is " + i);
//           System.out.println(this); 
//        });
        

//        thisReferenceExample.execute();

    }

    public String toString() {
        return "I am the main ThisReferenceExample class instance";
    }
}
