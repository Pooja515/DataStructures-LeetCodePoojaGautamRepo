class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1=0,ele2=0;
        int cnt1=0,cnt2=0;
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(cnt1==0 && nums[i] != ele2){
                ele1=nums[i];
                cnt1++;
            }
            else if(cnt2==0 && nums[i] != ele1){
                ele2 =nums[i];
                cnt2++;
            }

            else if(nums[i] == ele1){
                cnt1++;
            }
              else if(nums[i] == ele2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
    
        int c1=0,c2=0 ;
       for(int num : nums){
                if(num == ele1) c1++;
                else if(num == ele2) c2++;
       }
       List<Integer> ans = new ArrayList<>();
                if(c1>n/3 ) ans.add(ele1);
                if(c2>n/3) ans.add(ele2);
            

            return ans;
        
    }
}