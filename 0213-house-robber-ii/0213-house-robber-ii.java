class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        return Math.max(
            robRange(nums, 0, n - 2),
            robRange(nums, 1, n - 1)
        );
    }

    private int robRange(int[] nums, int start, int end) {
        int length = end - start + 1;
        int[] dp = new int[length];

        dp[0] = nums[start];

        if (length == 1) {
            return dp[0];
        }

        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < length; i++) {
            int numsIndex = start + i;

            dp[i] = Math.max(
                dp[i - 1],
                nums[numsIndex] + dp[i - 2]
            );
        }

        return dp[length - 1];
    }
}