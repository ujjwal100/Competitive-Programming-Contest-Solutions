/*
Q : https://leetcode.com/problems/decode-the-message
TC : O(N)
SC : O(1)
*/
class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        String ans = "";
        char c = 'a';
        map.put(' ', ' ');
        for (char ch : key.toCharArray()) {
            if (map.get(ch) == null) {
                    map.put(ch, c++);
                }
        }
        
        for (char ch : message.toCharArray()) {
            ans += map.get(ch);
        }
        return ans;
    }
}
