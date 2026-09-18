class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if(m>n){
            return -1;//invalid case
        }

        int r =0;
        for(int l=0;l<=n-m;l++){
            
            if(haystack.substring(l,l+m).equals(needle)){
                return l;
            }

        }
        return -1;

    }
}