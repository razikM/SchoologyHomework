package homework11;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number n: ");
        int n = scanner.nextInt();
        Number number = new Number(n);

        Thread t1 = new Thread(() -> {
            while (number.fizz());
        });

        Thread t2 = new Thread(() -> {
            while (number.buzz());
        });

       Thread t3 =  new Thread(() -> {
            while (number.fizzbuzz());
        });

       t1.start();
       t2.start();
       t3.start();

       while (number.number());

       t1.join();
       t2.join();
       t3.join();
    }
}
