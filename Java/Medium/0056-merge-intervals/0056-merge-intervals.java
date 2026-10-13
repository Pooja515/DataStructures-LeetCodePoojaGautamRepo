class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();

        for(int[] interval:intervals){
            if(res.isEmpty() || interval[0]>res.get(res.size()-1)[1]){
                res.add(interval);
            }
            else{
                int[] last = res.get(res.size()-1);
                last[1] = Math.max(last[1],interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}