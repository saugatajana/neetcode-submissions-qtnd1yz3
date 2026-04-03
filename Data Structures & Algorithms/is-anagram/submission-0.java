class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i=0;i<t.length();i++) {
            if(!map.containsKey(t.charAt(i))) return false;
            int newCount = map.get(t.charAt(i)) - 1;
            if(newCount == 0) map.remove(t.charAt(i));
            else map.put(t.charAt(i), newCount); 
        }
        return map.isEmpty();
    }
}
