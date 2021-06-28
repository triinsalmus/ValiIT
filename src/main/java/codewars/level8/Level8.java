package codewars.level8;

import java.util.Arrays;

public class Level8 {


    public static void main(String[] args) {
        //System.out.println(howOld("5 years old"));
        //System.out.println(nthPower(new int[]{3, 1, 2, 2}, 3));

//        int[] array = new int[]{1, 2, 10};
//        System.out.println(sumOfDifferences(array));

//        System.out.println(sum(new int[]{}));

        System.out.println(Arrays.toString(humanYearsCatYearsDogYears(10)));

    }


    /**
     * Ask a small girl - "How old are you?". She always says strange things... Lets help her!
     * For correct answer program should return int from 0 to 9.
     * Assume test input string always valid and may look like "1 year old" or "5 years old", etc..
     * The first char is number only.
     */
    public static int howOld(final String herOld) {
        char ageChar = herOld.charAt(0);
        int age = Character.getNumericValue(ageChar);
        if (age < 0 || age > 9) {
            return 0;
        } else {
            return age;
        }
    }

    /**
     * You are given an array with positive numbers and a non-negative number N.
     * You should find the N-th power of the element in the array with the index N.
     * If N is outside of the array, then return -1. Don't forget that the first element has the index 0.
     * Let's look at a few examples:
     * array = [1, 2, 3, 4] and N = 2, then the result is 3^2 == 9;
     * array = [1, 2, 3] and N = 3, but N is outside of the array, so the result is -1.
     */

    public static int nthPower(int[] array, int n) {
        if (n > array.length - 1) {
            return -1;
        }
        int a = array[n];
        int power = (int) Math.pow((double) a, (double) n);
        return power;
    }

    /**
     * Your task is to sum the differences between consecutive pairs in the array in descending order.
     * For example:
     * sumOfDifferences([2, 1, 10])
     * Returns 9
     * Descending order: [10, 2, 1]
     * Sum: (10 - 2) + (2 - 1) = 8 + 1 = 9
     * If the array is empty or the array has only one element the result should be 0 (Nothing in Haskell).
     */

//    public static int sumOfDifferences(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = 1; j < arr.length; j++) {
//                if (arr[j - 1] > arr[j]) {
//                    int tempNr = arr[j - 1];
//                    arr[j - 1] = arr[j];
//                    arr[j] = tempNr;
//                }
//            }
//        }
//        return 10;

//        if (arr) {
//
//        } else {
//            return 0;
//        }
//    }


    /**
     * You get an array of numbers, return the sum of all of the positives ones.
     * Example [1,-4,7,12] => 1 + 7 + 12 = 20
     * Note: if there is nothing to sum, the sum is default to 0.
     */

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
            } else if (arr == null) {
                return 0;
            }
        }
        return sum;
    }

    /**
     * I have a cat and a dog. I got them at the same time as kitten/puppy. That was humanYears years ago.
     * Return their respective ages now as [humanYears,catYears,dogYears]
     * NOTES:
     * humanYears >= 1
     * humanYears are whole numbers only
     * Cat Years
     * 15 cat years for first year
     * +9 cat years for second year
     * +4 cat years for each year after that
     * Dog Years
     * 15 dog years for first year
     * +9 dog years for second year
     * +5 dog years for each year after that
     */

    public static int[] humanYearsCatYearsDogYears(final int humanYears) {

        int catYears = 0;
        int dogYears = 0;
        int length = humanYears;

        int[] returnYearsArray = new int[]{};

        if (humanYears >= 1 && humanYears % 1 == 0) {
            for (int i = length; i >= 1; i--) {
                if (i == 1) {
                    catYears += 15;
                    dogYears += 15;
                } else if (i == 2) {
                    catYears += 9;
                    dogYears += 9;
                } else {
                    catYears += 4;
                    dogYears += 5;
                }
                returnYearsArray = new int[]{humanYears, catYears, dogYears};
            }
        }
        return returnYearsArray;
    }

}
