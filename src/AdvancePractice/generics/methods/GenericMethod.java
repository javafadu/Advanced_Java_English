package AdvancePractice.generics.methods;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {

        String[] stdList = {"Refael", "Donetollo", "Leonardo","Michelango"};
        Double[] scoreList = {99.8,86.7,23.56,59.3};
        Character[] gradeList = {'A','B','C','D'};

        // 1- Print all list
        printArray(stdList);
        printArray(scoreList);
        printArray(gradeList);

        // 2- Sort names
        System.out.println(Arrays.toString(orderArray(stdList)));
        System.out.println();

        // 3- Sort scores
        System.out.println(Arrays.toString(orderArray(scoreList)));
        System.out.println();

        // 4- Sort grades
        System.out.println(Arrays.toString(orderArray(gradeList)));
        System.out.println();

    }

    // Write a method that prints the array/list
    public static <T> void printArray(T[] array) {
        for (T t:array
             ) {
            System.out.print(t+" ");
        }
        System.out.println();
    }


    // Write a method that prints sorted Array/List
    public static <T extends Comparable<T>> T[] orderArray(T[] array) {
        for (int i = 0; i <array.length ; i++) {
            for (int j = i+1; j < array.length ; j++) {
                if(array[i].compareTo(array[j])>0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

}
