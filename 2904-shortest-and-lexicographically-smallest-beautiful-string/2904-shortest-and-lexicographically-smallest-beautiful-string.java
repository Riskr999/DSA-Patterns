class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        if(n==0){
            return "";
        }
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int matches = 0;
        String res = "";

        for(int right=0;right<n;right++){
            char rc = s.charAt(right);
            if(k>0){
                if(rc=='1') matches++;
            }
            
        
                
            while(matches==k){
               int currLen = right-left+1;
                String ans = s.substring(left,right+1);
                if(s.charAt(left)=='1'){
                    matches--;
                    
                }
                left++;
                if(currLen<minLength){
                    minLength = currLen;
                    res = ans;
                }
                else if(currLen==minLength && ans.compareTo(res)<0){
                    res = ans;
                }
            }
            
        }
    return res;
    }
}