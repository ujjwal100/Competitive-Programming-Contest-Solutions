class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int[][] art = new int[n][n];
        for (int[] row : art)
            Arrays.fill(row, -1);
        int[] a = new int[artifacts.length];
        
        for (int i = 0; i < artifacts.length; i++){
            int[] arts = artifacts[i];
            int r1 = arts[0];
            int c1 = arts[1];
            int r2 = arts[2];
            int c2 = arts[3];
            int cells = 0;
            
            for (int r = r1; r <= r2; r++)
                for (int c = c1; c <= c2; c++)
                {
                    art[r][c] = i;
                    cells++;
                }
            
            
            
            a[i] = cells;
        }
        
        for (int[] d : dig){
            if (art[d[0]][d[1]] != -1)
                a[art[d[0]][d[1]]]--;
        }
        
        int ans = 0;
        for (int i : a)
            if (i == 0)
                ans++;
        
        return ans;
        
        
        
    }
}
