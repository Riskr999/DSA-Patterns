public class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        long threshold = 1000;

        while (threshold <= n) {
            // Add the count of numbers that are greater than or equal to the current threshold
            totalCommas += (n - threshold + 1);
            
            // Move to the next comma threshold (e.g., 1,000 -> 1,000,000)
            threshold *= 1000;
        }

        return totalCommas;
    }
}
