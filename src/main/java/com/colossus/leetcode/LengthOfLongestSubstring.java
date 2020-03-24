package com.colossus.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tlsy1
 * @since 2019-02-19 10:14
 **/
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) throws InterruptedException {

      //  System.out.println("args = [" + lengthOfLongestSubstring("abcabcbb") + "]");

        final int[] a = {1};
        final int[] b = {2};
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                int temp = array[0];
//                array[0] = array[1];
//                array[1] = temp;
                int temp = a[0];
                a[0] = b[0];
                b[0] =temp;
            }
        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(a[0]);
//                System.out.println(b[0]);
//            }
//        });

        t1.start();
       // t2.start();
        System.out.println(a[0]);
        System.out.println(b[0]);

    }
}
