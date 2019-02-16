package com.colossus.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
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
        StringBuilder num1 = new StringBuilder();
        num1.append(node1.val);
        StringBuilder num2 = new StringBuilder();
        num2.append(node2.val);
        ListNode current1 = node1;
        ListNode current2 = node2;
        while (current1.next!=null){
            current1 = current1.next;
            num1.append(current1.val);
        }
        while (current2.next!=null){
            current2 = current2.next;
            num2.append(current2.val);
        }
        BigDecimal number1 =  new BigDecimal(num1.reverse().toString());
        BigDecimal number2 = new BigDecimal(num2.reverse().toString());
        BigDecimal sum = number1.add(number2);
        String sumStr = sum.toString();
        String sumLinod = new StringBuilder(sumStr).reverse().toString();
        ListNode listNode = null;
        ListNode currentNode = null;
        for (char c : sumLinod.toCharArray()) {
           if(listNode==null){
               listNode = new ListNode(Integer.parseInt(String.valueOf(c)));
               currentNode = listNode;
           }else {
               ListNode next = new ListNode(Integer.parseInt(String.valueOf(c)));
               currentNode.next =next;
               currentNode = next;
           }
        }
        return listNode;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
