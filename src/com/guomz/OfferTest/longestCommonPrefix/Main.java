package com.guomz.OfferTest.longestCommonPrefix;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 找出一组字符串的最长公共前缀
 */
public class Main {

    public static void main(String[] args) {
        String strs[] = {"aca", "cba"};
        int minLength = Arrays.stream(strs).map(String::length).sorted().collect(Collectors.toList()).get(0);
        System.out.println(minLength);
        char prefixArr[] = new char[minLength];

        int flag = 0;
        for (; flag < prefixArr.length; flag++) {
            for (int j = 0; j < strs.length; j++) {
                String str = strs[j];
                char prefix = str.charAt(flag);
                if (prefixArr[flag] == '\0') {
                    prefixArr[flag] = prefix;
                } else {
                    if (prefixArr[flag] == prefix) {
                        continue;
                    } else {
                        prefixArr[flag] = '\0';
                        System.out.println(new String(prefixArr).trim());
                        return;
                    }
                }
            }
        }

        System.out.println(new String(prefixArr).trim());
    }
}
