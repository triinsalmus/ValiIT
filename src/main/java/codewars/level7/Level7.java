package codewars.level7;

import java.util.Arrays;

public class Level7 {

    public static void main(String[] args) {
//        System.out.println(toJadenCase(null));
        int[] array = {15, 11, 10, 7, 12};
//        System.out.println(Arrays.toString(solve(array)));

    }

    /**
     * Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013).
     * Jaden is also known for some of his philosophy that he delivers via Twitter.
     * When writing on Twitter, he is known for almost always capitalizing every word.
     * For simplicity, you'll have to capitalize each word, check out how contractions are expected
     * to be in the example below.
     * Your task is to convert strings to how they would be written by Jaden Smith.
     * The strings are actual quotes from Jaden Smith, but they are not capitalized in the same way
     * he originally typed them.
     * Example:
     * Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
     * Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
     */

    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase == "") {
            return null;
        } else {
            String[] words = phrase.split(" ");
            String capitalizeWord = ""; //loon muutuja, mida loopis hakkan täitma
            for (String w : words) { //loopin kõik sõnad lause sõnade hulgast läbi
                String first = w.substring(0, 1); //määran, et esimene asub alati sellises kohas
                String next = w.substring(1); //järgmised on alati peale esiemst
                capitalizeWord = capitalizeWord + first.toUpperCase() + next + " "; //täidan tühja muutujat
            }
            return capitalizeWord.trim();
        }
    }


    /**
     * In this Kata, you will be given an array of unique elements, and your task is to rearrange the values so that
     * the first max value is followed by the first minimum, followed by second max value then second min value, etc.
     * For example:
     * solve([15,11,10,7,12]) = [15,7,12,10,11]
     * The first max is 15 and the first min is 7. The second max is 12 and the second min is 10 and so on.
     * More examples in the test cases.
     * Good luck!
     */

//    public static int[] solve(int[] arr) {
//        int[] solveArray = new int[arr.length];
//        int i = 0;
//        int j = i + 1;
//        int x = arr.length;
//
//        while (x <= arr.length+1) {
//            int temp = arr[i];
//            int max;
//            int min;
//            while (j <= arr.length + 1) {
//                if (arr[i] >= temp) {
//                    max = arr[i];
//                }
//                while ()
//                else if (arr[i] <= temp) {
//                    min = arr[j];
//                }
//                temp = arr[i + 1];
//                solveArray[i] = max;
//                solveArray[j] = min;
//            }
//            i = i + 2;
//        }
//
//        return solveArray;
//    }


}
