class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> freq = new HashMap<>();
        int maxLength = 0,L = 0;

        for(int R=0;R<s.length();R++){
            char rc = s.charAt(R);
            freq.put(rc,freq.getOrDefault(rc,0)+1);
            
            while(freq.get(rc)>1){
                char lc = s.charAt(L);
                freq.put(lc,freq.get(lc)-1);
                if(freq.get(lc)==0) freq.remove(lc);
                L++;
            }
            maxLength = Math.max(maxLength,R-L+1);

        }

        return maxLength;
    }
}