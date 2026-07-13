class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        int[] outDegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        //Nested loop + build REVERSE graph
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                adj.get(v).add(u);     // reverse edge: v -> u
            }
            outDegree[u] = graph[u].length;  // outdegree from ORIGINAL graph
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] safe = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe[node] = true;

            for (int neighbour : adj.get(node)) {  // predecessors now
                outDegree[neighbour]--;
                if (outDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) result.add(i);
        }

        return result;
    }
}