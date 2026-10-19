class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> st = new ArrayDeque<>();

        for(int x : arr){
            int maxVal = x;

            while(!st.isEmpty()&&st.peek()>x){
                 maxVal = Math.max(maxVal,st.pop());
            } 
            st.push(maxVal);
        }
        return st.size();

    }
}