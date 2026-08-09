class Solution {
    int[] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        memo=new int[n];
        Arrays.fill(memo,-1);

        return f(0,k,arr,n);
    }
    int f(int ind , int k ,int[] arr , int n){
        if(ind == n) return 0;
        int len =0,maxi=Integer.MIN_VALUE , totalsum =Integer.MIN_VALUE;
        if(memo[ind] != -1) return memo[ind];
        for(int j=ind;j<Math.min(ind+k,n);j++){
            len++;
            maxi=Math.max(maxi,arr[j]);
            int sum = len * maxi + f(j+1,k,arr,n);
            totalsum = Math.max(totalsum,sum);
        }
        return memo[ind]= totalsum;
    }
}