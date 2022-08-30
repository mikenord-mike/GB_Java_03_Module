package ru.gb.mikenord.module03.homework04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LettersByOrderOutputter {
    private int nextLetterOrder = 1;

    public synchronized void outputA() {
            if (nextLetterOrder != 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print("A");
            nextLetterOrder = 2;
            notify();
    }

    public synchronized void outputB() {
            if (nextLetterOrder != 2) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print("B");
            nextLetterOrder = 3;
            notify();
    }

    public synchronized void outputC() {
            if (nextLetterOrder != 3) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print("C");
            nextLetterOrder = 1;
            notify();
    }
}

class OutputterTest {
    public static void main(String[] args) {
        LettersByOrderOutputter lettersByOrderOutputter = new LettersByOrderOutputter();

        ExecutorService lettersOrderManager = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            lettersOrderManager.submit(lettersByOrderOutputter::outputA);
            lettersOrderManager.submit(lettersByOrderOutputter::outputB);
            lettersOrderManager.submit(lettersByOrderOutputter::outputC);
        }

        lettersOrderManager.shutdown();
    }
}
