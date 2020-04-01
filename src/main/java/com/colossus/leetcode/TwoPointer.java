package com.colossus.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointer {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode addTwoNumbers(ListNode node1, ListNode node2) {

        return add(node1,node2,0);
    }

    public static ListNode add(ListNode node1, ListNode node2,int c){
        int v1 = 0;
        int v2 = 0;
        ListNode next1 = null;
        ListNode next2 = null;
        if(node1==null&&node2==null&&c==0){
            return null;
        }
        if(node1!=null){
            v1 = node1.val;
            next1 = node1.next;
        }
        if(node2!=null){
            v2 = node2.val;
            next2 = node2.next;
        }
        int v = (v1+v2+c)%10;
        //进位
        int c1 = (v1+v2+c)/10;
        ListNode result = new ListNode(v);
        result.next = add(next1,next2,c1);
        return result;
    }
    /**
     * 最接近三数之和 lc-16
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * 三数之和  lc-15
     * @param nums
     * @return
     */
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

    /**
     * 称最多水的容器 lc-11
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while (left!=right){
            int L = height[left];
            int R = height[right];
            if(L<R){
                maxArea = Math.max(maxArea,L*(right-left));
                left++;
            }else {
                maxArea = Math.max(maxArea,R*(right-left));
                right--;
            }
        }
        return maxArea;
    }

}
