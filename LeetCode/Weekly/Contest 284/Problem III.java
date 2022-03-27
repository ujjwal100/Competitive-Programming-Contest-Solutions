class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if (k==0)
            return nums[0];
        else if (k > 0 && n == 1)
            return ((k&1)==1)?-1:nums[0];
        else{
            int max = -1;
            for (int i = 0; i <= Math.min(k - 2, n - 1); i++)
                max = Math.max(max, nums[i]);
            int smax = nums.length >= k+1? nums[k] : -1;
            return Math.max(max, smax);
        }
        
    }
}
