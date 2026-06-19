class Solution {
    public int sumSubarrayMins(int[] arr) {
    int MOD = 1_000_000_007;
    int n = arr.length;
    long result = 0;
    Deque<Integer> stack = new ArrayDeque<>(); 

    for (int i = 0; i <= n; i++) {
        
        int curr = (i == n) ? 0 : arr[i];

        while (!stack.isEmpty() && arr[stack.peek()] > curr) {
            int j = stack.pop();             
            int left  = stack.isEmpty() ? j + 1 : j - stack.peek();
            int right = i - j;
            result = (result + (long) arr[j] * left * right) % MOD;
        }
        stack.push(i);
    }
    return (int) result;
    }
}
