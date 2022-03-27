class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long f1 =0, f2 = 0;
        long ans =0;
        for(char c : text.toCharArray()){
            if (c==pattern.charAt(0))f1++;
            else if(c==pattern.charAt(1)){
                ans += f1;
                f2++;
            }
        }
        
        if (pattern.charAt(0) != pattern.charAt(1))return ans + Math.max(f1, f2);
        else {
            return (f1+ f2+ 1) * (f1 + f2)/ 2;
        }
        
    }
}
