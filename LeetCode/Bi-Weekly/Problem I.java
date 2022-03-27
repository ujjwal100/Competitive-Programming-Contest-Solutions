class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> fr = new HashMap<>();
        for (int i : nums)
            fr.put(i, fr.getOrDefault(i, 0) + 1);
        boolean ans = true;
        for(int i : fr.values())
            if(i%2 == 1){
                ans = false;
                break;
            }
        return ans;
    }
}
