class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
      int n1 = s1.length(), n2 = s2.length();
      if (n1 > n2) return false;
      int[] s1count = new int[26];
      int[] windowCount = new int[26];
      int required  = 0;

      for(int i = 0;i<n1;i++){
       int c =  s1.charAt(i)-'a';
       if(s1count[c]==0) required++;
        
        s1count[c]++;
        }

        int matches = 0;

        for(int i =0 ;i<n1;i++){
            int c = s2.charAt(i)- 'a';
            if(s1count[c]>0){
                if(windowCount[c]==s1count[c]-1) matches++;
                else if(windowCount[c]== s1count[c])matches--;
            }
            windowCount[c]++;
            

        }
        if(required == matches) return true;
        for(int right = n1;right<n2;right++){
            int rc = s2.charAt(right) - 'a';
            if(s1count[rc]>0){
                if(windowCount[rc]==s1count[rc]-1) matches++;
                else if(windowCount[rc]==s1count[rc])matches--;
            }
            windowCount[rc]++;

            int lc = s2.charAt(right-n1)-'a';
            if(s1count[lc]>0){
                if(windowCount[lc]==s1count[lc]) matches--;
                else if(windowCount[lc]== s1count[lc]+1) matches++;
            }
            windowCount[lc]--;

            if(required == matches) return true;

        }
        return false;
        
    }  
}