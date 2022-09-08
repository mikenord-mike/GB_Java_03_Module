package ru.gb.mikenord.module03.homework05;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private final Semaphore carLimitSemaphore;

    public Tunnel(int length, int carsCount) {
        this.length = length;
        this.description = "Тоннель " + length + " метров";
        this.carLimitSemaphore = new Semaphore(carsCount / 2);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                carLimitSemaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                carLimitSemaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}