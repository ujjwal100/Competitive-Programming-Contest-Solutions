/*
Q :  https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/
TC : O(NM)
SC : O(NM)
*/
class Solution {
    static final int mod = (int)1e9 + 7;
    public int countPaths(int[][] grid) {
        int ans = 0;
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        for (int i=0; i < grid.length; i++) {
            for (int j =0; j < grid[0].length; j++) {
                ans = (ans +  getPaths(i, j, grid, dp))%mod;
            }
        }
        return ans;
    }
    
    int getPaths(int i, int j, int[][] grid, Integer[][] dp) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        
        dp[i][j] = 1;
        
        int[][] adj = {{i+1, j}, {i-1, j}, {i, j+1}, {i, j-1}};
        
        for (int k = 0; k < 4; k++) {
            if (adj[k][0] >= 0 && adj[k][1] >=0 && adj[k][0] < grid.length && adj[k][1] < grid[0].length && grid[adj[k][0]][adj[k][1]] > grid[i][j]) {
                dp[i][j] = (dp[i][j] + getPaths(adj[k][0], adj[k][1], grid, dp))%mod; 
            }
        }
        
        return dp[i][j];
    }
}
