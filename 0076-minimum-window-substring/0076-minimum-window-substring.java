class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] windowCount = new int[128];
        int[] tcount = new int[128];
        int required = 0;

        for(int i=0;i<m;i++){
            int c = t.charAt(i) ;
            if(tcount[c]==0) required++;
            tcount[c]++;
        }
        String e = "";
        int matches = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE; 
        for(int right =0; right<n;right++){
            int c = s.charAt(right);
        
            if(windowCount[c]==tcount[c]-1)matches++;

            windowCount[c]++;

            
            while(matches == required){
                if(right-left+1<minLength){
                    minLength = right-left+1;
                    e = s.substring(left,right+1);
                }
                int lc = s.charAt(left);
                if (tcount[lc] >= 0 && windowCount[lc] == tcount[lc]) matches--;
                windowCount[lc]--;
                left++;

            }

            

        }
        return e;
        
    }

}