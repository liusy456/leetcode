package com.colossus.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        int length = nums.length;
        Arrays.sort(nums);
        for(int i =0;i<length-1;i++){
            int L = i+1;
            int R = length-1;
            while (L<R){
                int sum = nums[i]+nums[L]+nums[R];
                int t = Math.abs(sum-target);
                if(t<min){
                    result = sum;
                    min = t;
                }
                if(sum<target){
                    L++;
                }else if(sum>target){
                    R--;
                }else {
                    return result;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0;i<nums.length-1;i++){
            if(nums[i]>0){
                continue;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int L = i+1;
            int R = nums.length-1;
            while (L<R){
                int sum = nums[i]+nums[L]+nums[R];
                if(sum==0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R&&nums[L]==nums[L+1]){
                        L++;
                    }
                    while (L<R&&nums[R]==nums[R-1]){
                        R--;
                    }
                    L++;
                    R--;
                }else if(sum>0){
                    R--;
                }else {
                    L++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums={-1,2,1,-4};
        int target = 1;
        System.out.println(threeSum.threeSumClosest(nums,target));
    }
}
