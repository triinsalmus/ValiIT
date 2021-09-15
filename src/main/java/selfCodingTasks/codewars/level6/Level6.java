package selfCodingTasks.codewars.level6;

import java.util.HashMap;
import java.util.Map;

public class Level6 {

    public static void main(String[] args) {

//        System.out.println(toCamelCase("The_Stealth_Warrior"));

//        System.out.println(deleteNth(new int[]{20, 37, 20, 21}, 1));

//        System.out.println(createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));

//        System.out.println(checkVin("7JTRH08L5EJ234829"));

        String[] array1 = {"arp", "live", "strong"};
        String[] array2 = {"lively", "alive", "harp", "sharp", "armstrong"};
        System.out.println(inArray(array1, array2));
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

    /**
     * Write a function that accepts an array of 10 integers (between 0 and 9),
     * that returns a string of those numbers in the form of a phone number.
     * Example:
     * createPhoneNumber([1, 2, 3, 4, 5, 6, 7, 8, 9, 0]) // => returns "(123) 456-7890"
     * The returned format must be correct in order to complete this challenge.
     * Don't forget the space after the closing parentheses!
     */

    public static String createPhoneNumber(int[] numbers) {
        String answer = "";
        String answer2 = "";
        String answer3 = "";

        for (int i = 0; i < 3; i++) {
            int number = numbers[i];
            answer += number;
        }

        for (int i = 3; i < 6; i++) {
            int number = numbers[i];
            answer2 += number;
        }

        for (int i = 6; i < numbers.length; i++) {
            int number = numbers[i];
            answer3 += number;
        }

        return "(" + answer + ") " + answer2 + "-" + answer3;
    }

    /**
     * https://www.codewars.com/kata/60a54750138eac0031eb98e1/train/java
     */

    public static boolean checkVin(String vin) {
        boolean answer = true;

        if (vin.length() != 17) {
            answer = false;
        }

        Map<Character, Integer> decodeMap = new HashMap<>();
        decodeMap.put('A', 1);
        decodeMap.put('B', 2);
        decodeMap.put('C', 3);
        decodeMap.put('D', 4);
        decodeMap.put('E', 5);
        decodeMap.put('F', 6);
        decodeMap.put('G', 7);
        decodeMap.put('H', 8);
        decodeMap.put('J', 1);
        decodeMap.put('K', 2);
        decodeMap.put('L', 3);
        decodeMap.put('M', 4);
        decodeMap.put('N', 5);
        decodeMap.put('P', 7);
        decodeMap.put('R', 9);
        decodeMap.put('S', 2);
        decodeMap.put('T', 3);
        decodeMap.put('U', 4);
        decodeMap.put('V', 5);
        decodeMap.put('W', 6);
        decodeMap.put('X', 7);
        decodeMap.put('Y', 8);
        decodeMap.put('Z', 9);

        Map<Integer, Integer> weightMap = new HashMap<>();
        weightMap.put(0, 8);
        weightMap.put(1, 7);
        weightMap.put(2, 6);
        weightMap.put(3, 5);
        weightMap.put(4, 4);
        weightMap.put(5, 3);
        weightMap.put(6, 2);
        weightMap.put(7, 10);
        weightMap.put(8, 0);
        weightMap.put(9, 9);
        weightMap.put(10, 8);
        weightMap.put(11, 7);
        weightMap.put(12, 6);
        weightMap.put(13, 5);
        weightMap.put(14, 4);
        weightMap.put(15, 3);
        weightMap.put(16, 2);

        int sum = 0;
        int product = 0;

        for (int i = 0; i < vin.length(); i++) {
            if (Character.toString(vin.charAt(i)).equals("I") || Character.toString(vin.charAt(i)).equals("O") || Character.toString(vin.charAt(i)).equals("Q")) {
                answer = false;
            }

            if (Character.isLetter(vin.charAt(i))) {
                product = decodeMap.get(vin.charAt(i)) * weightMap.get(i);
            } else {
                product = Character.getNumericValue(vin.charAt(i)) * weightMap.get(i);
            }

            sum += product;
        }

        if (sum % 11 == Character.getNumericValue(vin.charAt(8))) {
            answer = true;
        } else if (sum % 11 == 10) {
            if (Character.toString(vin.charAt(8)).equals("X")) {
                answer = true;
            }
        } else {
            answer = false;
        }

        return answer;
    }

    /**
     * https://www.codewars.com/kata/550554fd08b86f84fe000a58/train/java
     */
    public static String[] inArray(String[] array1, String[] array2) {

        String[] returnArray = {};


        return returnArray;
    }

    /**
     * https://www.codewars.com/kata/5282b48bb70058e4c4000fa7
     */

}
