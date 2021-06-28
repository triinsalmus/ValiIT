package codewars.level6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Level6 {

    public static void main(String[] args) {

//        System.out.println(toCamelCase("The_Stealth_Warrior"));

//        System.out.println(deleteNth(new int[]{20, 37, 20, 21}, 1));
    }

    /**
     * Complete the method/function so that it converts dash/underscore delimited words into camel casing.
     * The first word within the output should be capitalized only if the original word was capitalized
     * (known as Upper Camel Case, also often referred to as Pascal case).
     * Examples
     * "the-stealth-warrior" gets converted to "theStealthWarrior"
     * "The_Stealth_Warrior" gets converted to "TheStealthWarrior"
     */

    static String toCamelCase(String s) {
        String[] words = s.split("-|_");
        String camelCased = words[0];
        for (int i = 1; i <= words.length - 1; i++) {
            String first = words[i].substring(0, 1);
            String next = words[i].substring(1);
            camelCased = camelCased + first.toUpperCase() + next;
        }
        return camelCased;
    }

    /**
     * Alice and Bob were on a holiday. Both of them took many pictures of the places they've been,
     * and now they want to show Charlie their entire collection. However, Charlie doesn't like these sessions,
     * since the motive usually repeats. He isn't fond of seeing the Eiffel tower 40 times.
     * He tells them that he will only sit during the session if they show the same motive at most N times.
     * Luckily, Alice and Bob are able to encode the motive as a number.
     * Can you help them to remove numbers such that their list contains each number only up to N times, without changing the order?
     * Task
     * Given a list lst and a number N, create a new list that contains each number of lst at most N times without reordering.
     * For example if N = 2, and the input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next [1,2]
     * since this would lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].
     * Example
     * EnoughIsEnough.deleteNth(new int[] {20,37,20,21}, 1) // return [20,37,21]
     * EnoughIsEnough.deleteNth(new int[] {1,1,3,3,7,2,2,2,2}, 3) // return [1, 1, 3, 3, 7, 2, 2, 2]
     */
//    public static int[] deleteNth(int[] elements, int maxOccurrences) {
//        Map solveMap = new HashMap<>();
//
//        for (int item : elements) {
//            if (solveMap.containsKey(item)) {
//                int previousSameItem = (int) solveMap.get(item);
//                solveMap.put(item, previousSameItem);
//            } else {
//                solveMap.put(item, );
//            }
//        }
//        return solveMap.keySet().toArray();



//        int[] solveArray = new int[0];
//        int count = 0;
//
//        for (int i = 0; i < elements.length; i++) {
//            if (Arrays.asList(solveArray).contains(elements[i]) && ) {
//                for (int j = 1; j <= maxOccurrences; j++) {
//
//                }
//            } else {
//                solveArray[i] = elements[i];
//            }
//        }
//
//    }


}
