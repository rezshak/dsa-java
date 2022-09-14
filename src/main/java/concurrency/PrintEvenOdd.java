package main.java.concurrency;

public class PrintEvenOdd {

    int counter;
    final int N;

    PrintEvenOdd(int n) {
        N = n;
        counter = 1;
    }

    synchronized void printOddNumber() {
        while (counter < N) {
            while (counter % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(counter + " ");
            counter++;
            notify();
        }
    }

    synchronized void printEvenNumber() {
        while (counter < N) {
            while (counter % 2 == 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(counter + " ");
            counter++;
            notify();
        }
    }

    public static void main(String[] args) {

        PrintEvenOdd ped = new PrintEvenOdd(10);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ped.printEvenNumber();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ped.printOddNumber();
            }
        });

        t1.start();
        t2.start();
    }

}
