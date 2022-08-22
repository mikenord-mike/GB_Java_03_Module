package ru.gb.mikenord.module03.homework01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {

    public static void main(String[] args) {
        //  task 01 test

        Integer[] testArray = {1, 9, 0, 22, 33, 44, 55, 66};
        swapArrayElements(testArray, 2, 16);
        System.out.println(Arrays.toString(testArray));

        //  task 02 test

        ArrayList<Integer> testArrayList = convertArrayToList(testArray);
        System.out.println(testArrayList);

        //  task 03 test

        Box<Apple> appleBox01 = new Box<>();
        Box<Apple> appleBox02 = new Box<>();
        Box<Apple> appleBox03 = new Box<>();
        Box<Apple> appleBox05 = new Box<>();
        Box<Apple> appleBox06 = new Box<>();

        Box<Orange> orangeBox01 = new Box<>();
        Box<Orange> orangeBox02 = new Box<>();
        Box<Orange> orangeBox03 = new Box<>();

        Box<GoldenApple> goldenAppleBox01 = new Box<>();
        Box<GoldenApple> goldenAppleBox02 = new Box<>();

        appleBox01.addFruits(new Apple(), new Apple(), new Apple());
        appleBox02.addFruits(new Apple(), new Apple());
        appleBox03.addFruits(new Apple());
        appleBox05.addFruits(new Apple(), new Apple(), new Apple(), new Apple(), new Apple());
        appleBox06.addFruits(new Apple(), new Apple(), new Apple(), new Apple(), new Apple());

        orangeBox01.addFruits(new Orange(), new Orange(), new Orange());
        orangeBox02.addFruits(new Orange(), new Orange());
        orangeBox03.addFruits(new Orange(), new Orange(), new Orange(), new Orange(), new Orange());

        goldenAppleBox01.addFruits(new GoldenApple(), new GoldenApple());
        goldenAppleBox02.addFruits(new GoldenApple(), new GoldenApple(), new GoldenApple(), new GoldenApple());

            // compare test

        System.out.println(appleBox01.compare(appleBox06));
        System.out.println(appleBox05.compare(appleBox06));

        System.out.println(orangeBox02.compare(appleBox01));
        System.out.println(orangeBox02.compare(appleBox02));

        System.out.println(goldenAppleBox01.compare(appleBox02));

            // pour fruits test

        System.out.println(appleBox06);
        System.out.println(appleBox01);
        appleBox06.pourFruits(appleBox01);
        System.out.println(appleBox06);
        System.out.println(appleBox01);

        System.out.println(goldenAppleBox01);
        System.out.println(appleBox01);
        goldenAppleBox01.pourFruits(appleBox01);
        System.out.println(goldenAppleBox01);
        System.out.println(appleBox01);


    }

    //  task 01
    static <T> void swapArrayElements(T[] array, int firstIndex, int secondIndex) {
        if (array == null || array.length < 2
                || firstIndex < 0 || firstIndex > array.length - 1
                || secondIndex < 0 || secondIndex > array.length - 1) {
            return;
        }
        T tempVar = array[secondIndex];
        array[secondIndex] = array[firstIndex];
        array[firstIndex] = tempVar;
    }

    // task 02
    static <T> ArrayList<T> convertArrayToList(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ArrayList<T> result = new ArrayList<>();
        Collections.addAll(result, array);
        return result;
    }

}


