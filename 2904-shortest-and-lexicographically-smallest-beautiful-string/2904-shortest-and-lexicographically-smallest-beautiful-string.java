class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int ones = 0,left = 0;
        String ans = "";

        for(int right =0;right<n;right++){
            if(s.charAt(right)=='1') ones++;

            while(ones==k){
                String sub = s.substring(left,right+1);
                if (ans.isEmpty() || sub.length() < ans.length() || 
                   (sub.length() == ans.length() && sub.compareTo(ans) < 0)) {
                    ans = sub;
                }
                
                if(s.charAt(left)=='1') ones--;
                left++;
            }
        }
        return ans;
    }
}