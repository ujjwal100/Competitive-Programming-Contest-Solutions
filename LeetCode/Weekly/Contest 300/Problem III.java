/*
Q : Number of People Aware of a Secret
TC : O(N^2)
SC : O(N)
*/
class Solution {
    static final int mod = (int) 1e9 + 7;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        return fun(1, n, delay, forget, new Integer[n+1]);
    }
    
    int fun(int day, int n, int delay, int forget, Integer[] dp) {
        if (dp[day] !=  null) {
            return dp[day];
        }
        int start = day + delay;
        int ans = 0;
        if (start <= n) {
            int end = Math.min(n, day + forget - 1);
            for (int i = start; i <= end; i++) {
                ans = (ans%mod + fun(i, n, delay, forget, dp)%mod)%mod;
            }    
        }
        
        if (day + forget > n) {
                ans = (ans%mod + 1)%mod;
            }
        
        return dp[day] = ans;
    }
}
