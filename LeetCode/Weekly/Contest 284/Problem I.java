class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        ArrayList<Integer> keys = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (nums[i] == key)
                keys.add(i);
        List<Integer> ans = new ArrayList<>();
        for (int i : keys) {
            for (int j = Math.max(0, i - k); j <= Math.min(n-1, i + k); j++)
                if (ans.size() == 0 || j > ans.get(ans.size() - 1))
                    ans.add(j);
        }
        return ans;
        
    }
}
