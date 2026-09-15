class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        Set<Character> cc = new HashSet<>();
        int maxLen = 0,L =0;
        for(int R=0;R<n;R++){
            
            while(cc.contains(s.charAt(R))){
               
                cc.remove(s.charAt(L));
                L++;
            }
            cc.add(s.charAt(R));
            maxLen = Math.max(maxLen,R-L+1);
        }
        return maxLen;
    }
}