import java.util.*;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int fuel = startFuel;
        int i = 0;
        int stops = 0;
        
        while (fuel < target) {
            
            // Add all reachable stations to heap
            while (i < stations.length && stations[i][0] <= fuel) {
                maxHeap.add(stations[i][1]);
                i++;
            }
            
            // If no fuel available → cannot move
            if (maxHeap.isEmpty()) {
                return -1;
            }
            
            // Refuel with max fuel
            fuel += maxHeap.poll();
            stops++;
        }
        
        return stops;
    }
}
