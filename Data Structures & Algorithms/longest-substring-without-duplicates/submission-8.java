class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, i);
                
            } else {
                left = Math.max(map.get(s.charAt(i)) + 1, left);
                map.put(c, i); 
            }
            maxLen = Math.max(maxLen , i - left + 1);
        }
        return maxLen;
    }
}
