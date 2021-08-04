package codewars.level7;

import io.jsonwebtoken.lang.Strings;

import java.util.Arrays;
import java.util.Locale;

public class Level7 {

    public static void main(String[] args) {
//        System.out.println(toJadenCase(null));

//        int[] array = {15, 11, 10, 7, 12};
//        System.out.println(Arrays.toString(solve(array)));

//        String numbers = "1 2 -3 4 5";
//        System.out.println(highAndLow(numbers));

//        int[] array = {0, -1, -5};
//        System.out.println(oddOrEven(array));

//        System.out.println(solution("abc", "d"));

        System.out.println(tagCreator("iPhone mini 64GB Purple RT123LA"));
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

    public static int[] solve(int[] arr) { //lahendamata
        int[] solveArray = new int[arr.length];
//        Arrays.sort(arr);
        return solveArray;
    }

    /**
     * In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.
     * Example:
     * highAndLow("1 2 3 4 5")  // return "5 1"
     * highAndLow("1 2 -3 4 5") // return "5 -3"
     * highAndLow("1 9 3 4 -5") // return "9 -5"
     * Notes:
     * All numbers are valid Int32, no need to validate them.
     * There will always be at least one number in the input string.
     * Output string must be two numbers separated by a single space, and highest number is first.
     */
    public static String highAndLow(String numbers) {
        String[] stringArray = numbers.split(" ");
        int[] intArray = new int[stringArray.length];
        int min = Integer.parseInt(stringArray[0]);
        int max = Integer.parseInt(stringArray[0]);
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
            if (intArray[i] < min) {
                min = intArray[i];
            } else if (intArray[i] > max) {
                max = intArray[i];
            }
        }
        return max + " " + min;
    }

    /**
     * Given a list of integers, determine whether the sum of its elements is odd or even.
     * Give your answer as a string matching "odd" or "even".
     * If the input array is empty consider it as: [0] (array with a zero).
     */
    public static String oddOrEven(int[] array) {
        int sum = 0;
        String answer = "";

        for (int element : array) {
            sum += element;
            if (sum % 2 == 0) {
                answer = "even";
            } else {
                answer = "odd";
            }
        }
        return answer;
    }

    /**
     * Complete the solution so that it returns true if the first argument(string)
     * passed in ends with the 2nd argument (also a string).
     */

    public static boolean solution(String str, String ending) {
        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = ending.length() - 1; j >= 0; j--) {
                if (str.charAt(i) == ending.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * oma mure lahendamiseks:
     * create a tag from a sentence with both upper- and lowercases,
     * also tag means that the words should be in lowercase and separated with -
     */

    public static String tagCreator(String sentence) {
        String answer = "";
        String words[] = sentence.toLowerCase().split(" ");
        for (String word : words) {
            answer += word + "-";
        }
        return answer;
    }
}
