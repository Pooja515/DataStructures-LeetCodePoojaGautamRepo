class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time:times){
            int u=time[0];
            int v=time[1];
            int t=time[2];

            adj.get(u).add(new int[] {v,t});
           // adj.get(v).add(new int[] {u,t});
        }

        int[] traveltime = new int[n+1];
        Arrays.fill(traveltime,Integer.MAX_VALUE);

        traveltime[k]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        pq.offer(new int[] {0,k});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int time = cur[0];
            int node = cur[1];

            if(time > traveltime[node]) continue;

            for(int[] edge: adj.get(node) ){
                int neighbor = edge[0];
                int tt = edge[1];

                int newtime = time +tt;
                if(newtime < traveltime[neighbor]){
                    traveltime[neighbor] = newtime;
                    pq.offer(new int[] {newtime,neighbor});
                }
            }
        }
        int maxtime=0;
        for(int i=1 ;i<=n;i++){
            if(traveltime[i] == Integer.MAX_VALUE) return -1;
            maxtime=Math.max(maxtime,traveltime[i]);

        }
        return maxtime;
    }
}