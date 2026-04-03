class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, longest = 0;
        while(right < s.length()) {
            int window = right - left + 1;
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            int maxFreq = maxFreq(map);
            if(window - maxFreq <= k) {
                longest = Math.max(longest, window);
            } else {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            right++;
        }
        return longest;
    }

    public int maxFreq(Map<Character, Integer> map) {
        int maxFreq = 0;
        for(int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        return maxFreq;
    }

}
