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

    public static int maxDistance(int cities, int howManyCitiesWithSpaceStation, int[] citiesIndexesWithSpaceStation) {
        if (isCorrect(cities, howManyCitiesWithSpaceStation, citiesIndexesWithSpaceStation) && (cities == howManyCitiesWithSpaceStation)) {
            return 0;
        } else if (isCorrect(cities, howManyCitiesWithSpaceStation, citiesIndexesWithSpaceStation)) {
            return findDistance(cities, citiesIndexesWithSpaceStation);
        } else {
            System.out.println("Cannot calculate, please check the input");
            return -1;
        }
    }

    public static boolean isCorrect(int cities, int howManyCitiesWithSpaceStation, int[] citiesIndexesWithSpaceStation) {
        return (cities >= 1 && cities <= Math.pow(10, 5)) &&
                (howManyCitiesWithSpaceStation >= 1 && howManyCitiesWithSpaceStation <= cities) &&
                (howManyCitiesWithSpaceStation == citiesIndexesWithSpaceStation.length);
    }

    public static int findDistance(int cities, int[] citiesIndexesWithSpaceStation) {
        ArrayList<Integer> citiesMaxDistanceArray = new ArrayList<>();
        int distanceToNearestSpaceStation = 0;
        for (int i = 0; i < cities; i++) {
            for (int j = 0; j < citiesIndexesWithSpaceStation.length; j++) {
                int smallestDistanceToNearestSpaceStation = Math.abs(i - (int) Array.get(citiesIndexesWithSpaceStation, 0));
                distanceToNearestSpaceStation = Math.abs(i - (int) Array.get(citiesIndexesWithSpaceStation, j));
                if (distanceToNearestSpaceStation >= smallestDistanceToNearestSpaceStation) {
                    distanceToNearestSpaceStation = smallestDistanceToNearestSpaceStation;
                }
            }
            citiesMaxDistanceArray.add(distanceToNearestSpaceStation);
        }
        return Collections.max(citiesMaxDistanceArray);
    }
}
