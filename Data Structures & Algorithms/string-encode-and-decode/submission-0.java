class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            int len = str.length();
            sb.append(len);
            sb.append("#");
            for(int i=0;i<len;i++) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decodeList = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            //Find the number first
            int num = 0;
            while(str.charAt(i) != '#') {
                num = 10*num + str.charAt(i)-'0';
                i++;
            }
            // i is already at # pos
            i++;

            // find the string
            StringBuilder sb = new StringBuilder();
            int end = i + num;
            while(i < end) {
                sb.append(str.charAt(i));
                i++;
            }
            decodeList.add(sb.toString());
        }
        return decodeList;
    }
}
