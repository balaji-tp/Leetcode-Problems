class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if(n==0 || n==1) return n;
        int maxi = 1, curr = 1;
        for(int i=1;i<n;i++){
            if(nums[i-1] < nums[i]) curr++;
            else curr = 1;
            maxi = Math.max(maxi, curr);
        }
        return maxi;
    }
}