class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();

        if(k==len) return "0";
        Deque<Character> st = new ArrayDeque<>();


        for(int i=0;i<len;i++){
            char current = num.charAt(i);

            while(!st.isEmpty()&&k>0&&st.peek()>current){
                st.pop();
                k--;
            }
            st.push(current);
        }

        while(k>0&&!st.isEmpty()){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pollLast());
        }

        while(sb.length()>1&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}