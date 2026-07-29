class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i<=n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int wt = time[2];

            adj.get(u).add(new int[] {v,wt});

        }

        int[] distance = new int[n+1];
        Arrays.fill(distance , (int) 1e9);
        distance[k] =0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

       //pair {distance ,src}
        pq.offer(new int[] {0,k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currdistance = curr[0];
            int node = curr[1];
            
            if(currdistance > distance[node]) continue;


            for(int[] neighbors : adj.get(node)){
                int neighbor = neighbors[0];
                int w = neighbors[1];

                int newdistance = currdistance + w;
                if(newdistance < distance[neighbor]){
                    distance[neighbor] = newdistance;
                    pq.offer(new int[] {newdistance , neighbor});
                }
            }
        }

        int maxi=0;
        for(int i=1;i<=n;i++){
            if(distance[i] == (int) 1e9 ){
                return -1;
            }
            maxi = Math.max(maxi,distance[i]);
        }
        return maxi;

    }
}