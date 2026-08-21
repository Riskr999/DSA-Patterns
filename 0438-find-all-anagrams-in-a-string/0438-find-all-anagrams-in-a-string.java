class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();

        List<Integer> result = new ArrayList<>();
        if (n < m) return result;
        int[] windowCount = new int[26];
        int[] pcount = new int[26];
        int required = 0;

        for(int i =0; i<m;i++){
            int c = p.charAt(i)- 'a';
            if(pcount[c]==0) required++;
            pcount[c]++;
        }

        int matches = 0;
        int index = 0;
        int right = 0;
        for(right = 0;right<m;right++){
            int c = s.charAt(right) - 'a';

            if(pcount[c]>0){
                
                if(windowCount[c]==pcount[c]-1)matches++;
                else if(windowCount[c]==pcount[c]) matches--;


            }
            
            windowCount[c]++;


        }
        if(matches==required) result.add(0);
        for(right = m;right<n;right++){
            int rc = s.charAt(right) - 'a';
            if(pcount[rc]>0){
                if(windowCount[rc]==pcount[rc]-1) matches++;
                else if(windowCount[rc]==pcount[rc])matches--;
            }
            windowCount[rc]++;

            int lc = s.charAt(right-m)-'a';
            if(pcount[lc]>0){
                if(windowCount[lc]==pcount[lc]) matches--;
                else if(windowCount[lc]== pcount[lc]+1) matches++;
            }
            windowCount[lc]--;

            if(required == matches) result.add(right-m+1);

        }
        return result;
    }
}