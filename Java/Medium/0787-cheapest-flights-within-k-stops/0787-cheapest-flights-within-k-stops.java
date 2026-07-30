class Solution {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

     
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, src, 0});  

        int[] distance = new int[n];
        Arrays.fill(distance, (int) 1e9);
        distance[src] = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int stops = current[0];  // Number of stops so far
            int node = current[1];  // Current node
            int currcost = current[2];  // Cost to reach the current node

            // If the number of stops exceeds K, continue to the next iteration
            if (stops > K)
                continue;

            // Iterate over all the adjacent nodes (next destinations)
            for (int[] adjNode : adj.get(node)) {
                int neighborNode = adjNode[0];  // neighborNode node
                int wt = adjNode[1];  // Cost of the flight to the next destination

                // If a shorter path to the adjacent node is found, update the distance
                int newdistance= currcost + wt ; 
                if (newdistance < distance[neighborNode] && stops <= K) {
                    distance[neighborNode] = newdistance;  // Update the distance
                    q.offer(new int[]{stops + 1, neighborNode, newdistance}); 
                }
            }
        }

        // If destination node is unreachable, return -1
        if (distance[dst] == (int) 1e9)
            return -1;

        return distance[dst];  // Return the minimum cost to reach the destination
    }
}