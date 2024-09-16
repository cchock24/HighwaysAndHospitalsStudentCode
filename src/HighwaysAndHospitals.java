import java.util.ArrayList;
// Highways and Hospitals by Caden Chock
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
        long num = n;
        long road = highwayCost;
        long hospital = hospitalCost;
        // If Hospital Cheaper than Highway Better to Just Build Only Hospital for Each City
        if(hospitalCost < highwayCost) {
            return num*hospital;
        }

        int[] group = new int[n+1];



        // Array of Cities and their roots
        for(int i = 0; i < cities.length; i++){
            int city2 = cities[i][1];
            int city1 = cities[i][0];
            if(group[city2] == 0){
                if(city2 != group[city1]){
                    group[city2] = city1;
                }
            }
            else{
                if(group[city2] != group[city1]){
                    group[group[city2]] = city1;
                }
            }
            for(int j = 1; j < group.length; j++){
                if(group[j] == city2){
                    group[j] = city1;
                }
            }
        }
        long roots = 0;
        for(int i = 1; i < group.length; i++){
            if(group[i] == 0){
                roots++;
            }
        }
        if(roots == 0){
            roots++;
        }

        // Total = hospitalCost * #Cluster + highwayCost (Cities - # clusters)
        long cost = (hospital * roots);
        cost += (road * (num - roots));
        return cost;
    }
}
/*

*/