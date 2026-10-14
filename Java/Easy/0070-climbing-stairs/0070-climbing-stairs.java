class Solution {
   
    public int climbStairs(int n) {

        // BASE CASE TO STEP O STAIRS THERE IS 1 WAY AND 1 STEP THERE IS 1 WAY 

        if(n<=1) return 1;
        int[] memo= new int[n];
        Arrays.fill(memo,-1);

        // RETURN COUNT OF ALL DISTINCT WAYS TO REACH N STAIRS 
        
        return  climb(n-1,memo) +  climb(n-2,memo);
    }

    int climb(int i,int[] memo){
        if(i<=1) return 1;

        if(memo[i] != -1) return memo[i];

        return memo[i] = climb(i-1,memo) +climb(i-2,memo);
    }
}

/*
T.C : O(2^N)  // TWO CHOICES WE HAVE 1 STEP OR TWO STEPS FUNCTION CALL                       
S.C : O(N) // RECURSIVE CALL STACK DEPTH     

**/