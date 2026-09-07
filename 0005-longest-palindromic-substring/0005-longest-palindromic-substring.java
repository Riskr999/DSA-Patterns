class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int n = s.length();
        int maxLen = 1;
        int maxStart = 0;
        for(int i=0;i<s.length();i++){
            //odd
            int left = i,right = i;
            while(left>=0&&right<n&&s.charAt(left)==s.charAt(right)){
                int len = right-left+1;
                if(len>maxLen){
                    maxLen = len;
                    maxStart = left;
                }
                left--;
                right++;
            }
            left = i;
            right = i+1;
            while(left>=0&&right<n&&s.charAt(left)==s.charAt(right)){
                int len = right-left+1;
                if(len>maxLen){
                    maxLen = len;
                    maxStart = left;
                }
                left--;
                right++;
            }
        }
        return s.substring(maxStart,maxStart+maxLen);

    }
}