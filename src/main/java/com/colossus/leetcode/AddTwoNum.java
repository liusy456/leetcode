package com.colossus.leetcode;

import java.io.IOException;

/**
 * 递归
 * @author Tlsy1
 * @since 2019-02-16 15:15
 **/
public class AddTwoNum {

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

    public static void main(String[] args) throws IOException {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode l = addTwoNumbers(l1,l2);
        System.out.println("dsfsd");

    }
}
