class Solution {
    public boolean backspaceCompare(String s, String t) {
        return StringFormer(s).equals(StringFormer(t));
              
    }

    private static String StringFormer(String str){
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i<str.length();i++){
            char ch = str.charAt(i);

            if(ch != '#'){
                stack.push(i);
            }
            else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){

            result.insert(0,stack.pop());
        }
       
    return result.toString();
    }
    
}

