package ru.gb.mikenord.module03.homework01;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> boxItemList;

    public Box() {
        this.boxItemList = new ArrayList<>();
    }

    public void addFruits(T... addedFruits) {
        if (addedFruits != null) {
            this.boxItemList.addAll(Arrays.asList(addedFruits));
        }
    }

    private float getWeight() {
        if (boxItemList.size() == 0) {
            return 0.0f;
        }
        return boxItemList.get(0).getFruitWeight() * this.boxItemList.size();
    }

    public boolean compare(Box<?> anotherBox) {
        if (anotherBox == null) {
            return false;
        }
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001f;
    }

    public void pourFruits(Box<? super T> anotherBox) {
        for (T t : boxItemList) {
            anotherBox.addFruits(t);
        }
        boxItemList.clear();
    }

    @Override
    public String toString() {
        return boxItemList.toString();
    }
}
