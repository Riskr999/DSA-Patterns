class Solution {
    public String removeOuterParentheses(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '('){
                if(!stack.isEmpty()){
                    sb.append(ch);
                }
                stack.push(ch);
            }
            if(ch == ')'){
                
                stack.pop();
                if(!stack.isEmpty()){
                    sb.append(ch);
                }
            }
            

        }
        
        

        return sb.toString();

        
    }
}
