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
            int temp2 = city2;
            int temp1 = city1;
            int root;
            int counter = 1;
            while(group[city1] > 0){
                city1 = group[city1];
                // Keeps Track of Order
                if(group[city1] <= 0){
                    group[city1] -= counter;
                }
                counter++;
            }
            counter = 1;
            while(group[city2] > 0){
                city2 = group[city2];
                // Keeps Track of Order
                if(group[city2] <= 0){
                    group[city2] -= counter;
                }
                counter++;
            }
            root = city1;
            if(city1 != city2){
                // Weight Balancing
                if(group[city2] > group[city1])
                {
                    group[city1] += group[city2];
                    group[city2] = city1;
                }
                else{
                    group[city2] += group[city1];
                    group[city1] = city2;
                    root = city2;
                }
            }
            // Path Compression
            while(group[temp1] > 0){
                int temp3 = group[temp1];
                group[temp1] = root;
                temp1 = temp3;
            }
            while(group[temp2] > 0){
                int temp4 = group[temp2];
                group[temp2] = root;
                temp2 = temp4;
            }
        }

        long roots = 0;
        // Gets the Number of Clusters
        for(int i = 1; i < group.length; i++){
            if(group[i] <= 0){
                roots++;
            }
        }

        // Total = hospitalCost * #Cluster + highwayCost (Cities - # clusters)
        long cost = (hospital * roots);
        cost += (road * (num - roots));
        return cost;
    }
}
