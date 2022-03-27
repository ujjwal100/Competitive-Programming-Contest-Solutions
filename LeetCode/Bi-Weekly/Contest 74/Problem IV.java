class Solution {
    
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        int[] psum = new int[n];
        
        for(int i=0;i<n;i++){
            psum[i] = (floor.charAt(i)=='0'? 0 : 1) + (i>0? psum[i-1]:0);
        }
        
        Integer[][] dp = new Integer[n+1][numCarpets+1];
       
        return psum[n-1] - getMaxOnes(0, n, numCarpets, carpetLen, psum, dp);
        
    }
    
    int getMaxOnes(int i, int n, int numCarpets, int carpetLen, int[] psum, Integer[][] dp) {
        if(numCarpets ==0)return 0;
        if (i>=n)return 0;
        if (n-i <= carpetLen) return psum[n-1] - (i>0?psum[i-1]:0);
        if(dp[i][numCarpets] != null) return dp[i][numCarpets];
        
        int op1 = psum[i + carpetLen - 1] - (i>0?psum[i-1]:0) + getMaxOnes(i + carpetLen, n, numCarpets - 1, carpetLen, psum, dp);
        
        int op2 = getMaxOnes(i+1, n, numCarpets, carpetLen, psum, dp);
        
        return dp[i][numCarpets] = Math.max(op1, op2);
    }
}
