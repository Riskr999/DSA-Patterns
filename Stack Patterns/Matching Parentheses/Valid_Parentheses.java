class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() != map.get(c) ){
                    return false;
                }
                stack.pop();
            }else{
            stack.push(c);
            }
        }

        return stack.isEmpty();
     }
}
