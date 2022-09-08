package ru.gb.mikenord.module03.homework05;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {

        Lock raceLocker = new ReentrantLock();
        CountDownLatch raceStartFlag = new CountDownLatch(CARS_COUNT);
        CountDownLatch raceFinishFlag = new CountDownLatch(CARS_COUNT);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        raceLocker.lock();

        Race race = new Race(new Road(60), new Tunnel(80, CARS_COUNT), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), raceLocker, raceStartFlag, raceFinishFlag);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            raceStartFlag.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            raceLocker.unlock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            raceFinishFlag.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}