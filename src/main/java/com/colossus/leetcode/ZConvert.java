package com.colossus.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZConvert {

    public String convert(String s, int numRows) {
        if(numRows<=1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i =0;i<numRows;i++){
            list.add(new StringBuilder());
        }
        int flag = -1;
        int i = 0;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if(i==0||i==numRows-1){
                flag = -flag;
            }
            i = i+flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            res.append(stringBuilder);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ZConvert zConvert = new ZConvert();
        System.out.println(zConvert.convert("LEETCODEISHIRING",3));
    }
}
