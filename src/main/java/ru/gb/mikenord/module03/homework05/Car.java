package ru.gb.mikenord.module03.homework05;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private CountDownLatch raceStartFlag;
    private CountDownLatch raceFinishFlag;
    private Lock raceLocker;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, Lock raceLocker, CountDownLatch raceStartFlag, CountDownLatch raceFinishFlag) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.raceStartFlag = raceStartFlag;
        this.raceFinishFlag = raceFinishFlag;
        this.raceLocker = raceLocker;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            raceStartFlag.countDown();
            raceLocker.lock();

        } catch (Exception e) {
            e.printStackTrace();
        }
        raceLocker.unlock();
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (raceLocker.tryLock()) {
            System.out.println(this.name + " - победитель гонки!");
        }
        raceFinishFlag.countDown();
    }
}