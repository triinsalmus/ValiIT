package selfCodingTasks.hackerrank.easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class FlatlandSpaceStations {
    /**
     * https://www.hackerrank.com/challenges/flatland-space-stations/problem
     * <p>
     * Determine the maximum distance from any city to its nearest space station.
     * int n = the number of cities
     * int c[m] = the indices of cities with a space station
     * cities begin from 0
     * Returns int: the maximum distance any city is from a space station
     */

    public static void main(String[] args) {
//        int[] array = {0, 4};
//        System.out.println(maxDistance(5, 2, array)); //2

//        int[] array = {0, 1, 2, 4, 3, 5};
//        System.out.println(maxDistance(6, 6, array)); //0

//        int[] array = {0, 1};
//        System.out.println(maxDistance(3, 2, array)); //1

        int[] array = {0};
        System.out.println(maxDistance(3, 2, array)); //error
    }

    public static int maxDistance(int cities, int howManyCities, int[] citiesIndexes) {
        if (isCorrect(cities, howManyCities, citiesIndexes) && (cities == howManyCities)) {
            return 0;
        } else if (isCorrect(cities, howManyCities, citiesIndexes)) {
            return findDistance(cities, citiesIndexes);
        } else {
            System.out.println("Cannot calculate, please check the input");
            return -1;
        }
    }

    public static boolean isCorrect(int cities, int howManyCities, int[] citiesIndexes) {
        return (cities >= 1 && cities <= Math.pow(10, 5)) &&
                (howManyCities >= 1 && howManyCities <= cities) &&
                (howManyCities == citiesIndexes.length);
    }

    public static int findDistance(int cities, int[] citiesIndexes) {
        ArrayList<Integer> citiesMaxDistanceArray = new ArrayList<>();
        int distanceToNearest = 0;
        for (int i = 0; i < cities; i++) {
            for (int j = 0; j < citiesIndexes.length; j++) {
                int smallestDistanceToNearest = Math.abs(i - (int) Array.get(citiesIndexes, 0));
                distanceToNearest = Math.abs(i - (int) Array.get(citiesIndexes, j));
                if (distanceToNearest >= smallestDistanceToNearest) {
                    distanceToNearest = smallestDistanceToNearest;
                }
            }
            citiesMaxDistanceArray.add(distanceToNearest);
        }
        return Collections.max(citiesMaxDistanceArray);
    }
}
