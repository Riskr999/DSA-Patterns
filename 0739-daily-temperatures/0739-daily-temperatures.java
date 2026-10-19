class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] answer = new int[n]; 
        for(int i=0;i<n;i++){

            while(!st.isEmpty()&&temperatures[st.peek()]<temperatures[i]){
                int prevIndex = st.pop();
                answer[prevIndex] = i-prevIndex;
                
            }
            st.push(i);
        }
        return answer;
    }
}