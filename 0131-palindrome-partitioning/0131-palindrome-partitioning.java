class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        laDoubleP(s,0,new ArrayList<>(),result);
        return result;
        
    }
    private void laDoubleP(String s,int start, List<String> path, List<List<String>> result ){

        if(start == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int end = start; end<s.length();end++){
            if(IsPalindrome(s,start,end)){
                path.add(s.substring(start,end+1));

                laDoubleP(s,end+1,path,result);
                path.remove(path.size()-1);

            }
        }
    }
    private boolean IsPalindrome(String s, int start, int end){
        while(start<end){
           if(s.charAt(start)!=s.charAt(end)){
                return false;
           } 
            start++;
            end--;
        }
        return true;
    }
}