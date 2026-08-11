class Solution {
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtracking(digits,0,mapping,new StringBuilder(),result);
        return result;



    }
    private void backtracking(String digits,int index, String[] mapping,StringBuilder sb,List<String> result){
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }
        
        char c = digits.charAt(index);       // e.g. '2'
        int digitValue = c - '0';         // e.g. 2
        String letters = mapping[digitValue];  // e.g. "abc"

        for(int i = 0;i<letters.length();i++){
            sb.append(letters.charAt(i));
            backtracking(digits,index+1,mapping,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }

        
    }
}