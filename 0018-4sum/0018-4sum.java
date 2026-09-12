class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return result;

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Early exit optimizations for loop i
            long minSumI = (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (minSumI > target) break;

            long maxSumI = (long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (maxSumI < target) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Early exit optimizations for loop j
                long minSumJ = (long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (minSumJ > target) break;

                long maxSumJ = (long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2];
                if (maxSumJ < target) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicate values for left and right
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}