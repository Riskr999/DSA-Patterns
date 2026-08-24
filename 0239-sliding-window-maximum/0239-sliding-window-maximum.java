class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> dequeue = new ArrayDeque<>();
        int[] result = new int[n-k+1];

        for(int right =0;right<n;right++){
            while(!dequeue.isEmpty()&&nums[dequeue.peekLast()]<=nums[right]){
                dequeue.pollLast();
            }
            dequeue.addLast(right);
            while(!dequeue.isEmpty()&&dequeue.peekFirst()<right-k+1){
                dequeue.pollFirst();
            }
            if(right >= k-1){
                result[right-k+1]= nums[dequeue.peekFirst()];
            }
        }
        return result;
    }
}