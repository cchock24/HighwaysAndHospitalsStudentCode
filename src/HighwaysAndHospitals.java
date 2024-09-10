import java.util.ArrayList;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // If Hospital Cheaper than Highway Better to Just Build Only Hospital for Each City
        if(hospitalCost < highwayCost) {
            return n*hospitalCost;
        }

        // Find the Number of Connections of Each City
        int[] numConnect = new int[n];
        for(int i = 0; i < cities.length; i++){
            int city1 = cities[i][0];
            int city2 = cities[i][1];
            numConnect[city1]++;
            numConnect[city2]++;
        }
        // If Only One Connection then Make Connection


        // Find Longest Single Connection Between Cities
        //Take Spot see what connects to that spot see what connects to that spot

        return 0;
    }
}
