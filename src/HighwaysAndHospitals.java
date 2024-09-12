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
        // If Hospital Cheaper than Highway Better to Just Build Only Hospital for Each City
        if(hospitalCost < highwayCost) {
            return n*hospitalCost;
        }
        // Declare Lists
        ArrayList<Integer>[] connections = new ArrayList[n];
        ArrayList<Integer>[] group = new ArrayList[n+1];
        //Initialize Lists
        for(int i = 0; i < n; i++){
            connections[i] = new ArrayList<Integer>();
            group[i] = new ArrayList<Integer>();
        }
        group[n] = new ArrayList<Integer>();
        // Find the Number of Connections of Each City
        for(int i = 0; i < cities.length; i++){
            int city1 = cities[i][0];
            int city2 = cities[i][1];
            if(i == city1){
                connections[i].add(city2);
                connections[city2].add(city1);
            }
        }
        for(int i = 1; i <= n; i++){
            group[n].add(i);
        }
        int d = 1;
        // Add Each City to a Group until every city has been added to a group
        while(!group[n].isEmpty()){
            // Add a Starting City to Group 1
            group[d].add(group[n].remove(0));
            if(group[n].isEmpty()){
                break;
            }
            // If Group 1 Increases Run Again
            int num = group[d].size();
            int num2 = group[d].size();
            do{
                num = group[d].size();
                // If Connections to 1 add to Group1 otherwise add to different group (Skip 1)
                for(int i = 0; i < group[n].size(); i++){
                    // Checks if City has any Connections
                    if(!connections[group[n].get(i)].isEmpty()){
                        for(int j = 0; j < connections[group[n].get(i)].size(); j++){
                            // If Connected to Something in Group
                            {
                                for(int k = 0; k < group[d].size(); k++){
                                    if(connections[group[n].get(i)].get(j) == group[d].get(k)){
                                        group[d].add(i); // Talk To Mr. Blick About Effect
                                        group[n].remove(i);
                                    }
                                }
                            }
                        }
                    }

                }
                num2 = group[1].size();
                if(group[n].isEmpty()){
                    break;
                }
            } while(num2 > num);
            d++;
        }
        int cost = 0;
        // Each Connection clump H + (v-1)R
        for(int i = 0; i < group.length-1; i++){
            if(!group[i].isEmpty()){
                cost += hospitalCost + (group[i].size() -1) * highwayCost;
            }
        }
        return cost;
    }
}
/*

*/