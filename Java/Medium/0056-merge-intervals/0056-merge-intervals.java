class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        for(int[] interval:intervals){
            if(ans.isEmpty() || interval[0] > ans.get(ans.size()-1)[1]){
                ans.add(interval);
            }
            else{
                int[] last = ans.get(ans.size()-1);
                last[1] = Math.max(last[1],interval[1]);
            }

        }
        return ans.toArray(new int[ans.size()][]) ;
    }
}