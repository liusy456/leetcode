package com.colossus.leetcode;

/**
 * 不用字符串的判断回文数字
 */
public class Palindrome {

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int y = 0;
        int ox = x;
        while (x!=0){
            int p = x%10;
            if(y>Integer.MAX_VALUE||(y==Integer.MAX_VALUE&&p>7)){
                return false;
            }
            if(y<Integer.MIN_VALUE||(y==Integer.MIN_VALUE&&p<-8)){
                return false;
            }
            y = y*10+p;
            x= x/10;
        }
        return ox==y;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome(121));
    }
}
