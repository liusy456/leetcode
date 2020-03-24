package com.colossus.leetcode;

/**
 * 简单动态规划
 */
public class Massage {
    public int massage(int[] nums) {
        int length = nums.length;
        if(length<=0){
            return 0;
        }
        if(length==1){
            return nums[0];
        }
        int[] dp  = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2;i<length;i++){
            //在今天是不是干活里选一个最优值
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[length-1];
    }
}
