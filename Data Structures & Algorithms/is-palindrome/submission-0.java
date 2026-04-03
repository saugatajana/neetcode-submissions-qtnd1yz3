class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        char[] arr = s.toCharArray();
        while(left < right) {
            if(!Character.isLetterOrDigit(arr[left])) left++;
            else if(!Character.isLetterOrDigit(arr[right])) right--;
            else if(Character.toLowerCase(arr[left]) != Character.toLowerCase(arr[right])) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
