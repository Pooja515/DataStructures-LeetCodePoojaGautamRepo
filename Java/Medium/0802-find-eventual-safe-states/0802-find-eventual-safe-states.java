class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseAdj = new ArrayList<>();
        int[] outDegree = new int[n];

        for (int i = 0; i < n; i++) {
            reverseAdj.add(new ArrayList<>());
        }

        // Build reverse graph + track outdegree of original graph
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                reverseAdj.get(v).add(u); // reverse edge: v -> u
            }
            outDegree[u] = graph[u].length;
        }

        // Start with terminal nodes (outDegree == 0)
        Queue<Integer> queue = new LinkedList<>();
        boolean[] safe = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Kahn's algorithm (propagate safety backward)
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe[node] = true;

            for (int pred : reverseAdj.get(node)) {
                outDegree[pred]--;
                if (outDegree[pred] == 0) {
                    queue.offer(pred);
                }
            }
        }

        // Collect all safe nodes
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i])
                result.add(i);
        }

        return result;
    }
}