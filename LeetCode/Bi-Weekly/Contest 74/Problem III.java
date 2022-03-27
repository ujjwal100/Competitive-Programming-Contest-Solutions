class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq  = new PriorityQueue<>(nums.length, Collections.reverseOrder());
        double s=0;
        for(int i : nums){
            s+= i;
            pq.add(i*1.0);
        }
        double h = s/2.0;
        
        int ans =0;
        while(s > h){
            double x = pq.poll();
            s -= x/2.0;
            pq.add(x/2.0);
            ans++;
        }
        return ans;
    }
}
