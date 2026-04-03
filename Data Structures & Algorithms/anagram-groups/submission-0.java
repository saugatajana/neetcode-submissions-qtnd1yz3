class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String sortedStr = sort(str);
            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);
            map.put(sortedStr, list);
        }
        for(List<String> list : map.values()) {
            res.add(list);
        }
        return res;

    }

    public String sort(String str) {
        char[] charSeq = str.toCharArray();
        Arrays.sort(charSeq);
        return new String(charSeq);
    }
}
