class Solution {

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;
        // 1. Store minimum effort required to reach each cell
        int[][] minEffort =  new int[rows][cols];

        for (int[] row : minEffort) {
            Arrays.fill(row,Integer.MAX_VALUE );
        }
        // 2. PriorityQueue
        // {row, col, effort}
     
        PriorityQueue<int[]> pq =new PriorityQueue<>((a, b) ->Integer.compare(a[2],b[2]));
        // 3. Start from (0, 0)
        minEffort[0][0] = 0;

        pq.offer(new int[]{ 0,0,0});
        // Directions:
        // up, down, left, right

        int[][] directions = {{-1, 0},{1, 0},{0, -1}, {0, 1} };

        // 4. Dijkstra
       
        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int row = current[0];

            int col =current[1];

            int currentEffort = current[2];

            // We reached destination with minimum effort
            if (row == rows - 1 && col == cols - 1) {
                return currentEffort;
            } 
            // 5. Explore four neighbors
           
            for (int[] direction :directions) {

                int nextRow =row + direction[0];
                int nextCol =col + direction[1];
                // Check boundarie
                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                    continue;
                }
                // Calculate effort of this single move

                int edgeEffort =Math.abs(heights[row][col] - heights[nextRow][nextCol]);
                // Path effort is the maximum effort
                // encountered on the entire path

                int newEffort = Math.max(currentEffort,edgeEffort );
                // Relaxation
                if (newEffort < minEffort[nextRow][nextCol]) {
                         minEffort[nextRow][nextCol] =newEffort;


                    pq.offer(new int[]{ nextRow,nextCol,newEffort } );
                }
            }
        }


        return 0;
    }
}