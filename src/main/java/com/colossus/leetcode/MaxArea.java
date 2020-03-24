package com.colossus.leetcode;

public class MaxArea {
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
