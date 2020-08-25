package com.guomz.OfferTest.find_sub_sequences;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<List<Integer>> resultList = findSubsequences(new int[]{4,6,7,7});
        for (List<Integer> list: resultList){
            System.out.println(Arrays.toString(list.toArray()));
        }

//        List<Integer> list1 = new ArrayList<>();
//        list1.add(6);
//        list1.add(7);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(7);
//        list2.add(7);
//        System.out.println(list1.containsAll(list2));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {

        if (nums == null || nums.length < 2){
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 1; i <= Math.pow(2, nums.length) - 1; i ++){
            //生成二进制串
            String binaryStr = generateBinaryStr(i, nums.length);
            //根据二进制串中1的位置得到子序列
            List<Integer> tempList = generateSubSeq(nums, binaryStr);
            if (tempList.size() < 2){
                continue;
            }
            //若子串递增且不和之前的子串重复则加入结果集
            if (isAsc(tempList)){
                int hashValue = getHash(263, (int) 1E9 + 7, tempList);
                if (!resultSet.contains(hashValue)){
                    resultSet.add(hashValue);
                    resultList.add(tempList);
                }
            }
        }
        return resultList;
    }

    /**
     * 生成子串
     * @param nums
     * @param binaryStr
     * @return
     */
    private static List<Integer> generateSubSeq(int nums[], String binaryStr){
        List<Integer> tempList = new ArrayList<>();
        for (int j = 0; j < binaryStr.length(); j ++){
            if (binaryStr.charAt(j) == '1'){
                tempList.add(nums[j]);
            }
        }
        return tempList;
    }

    /**
     * 生成指定位数的二进制字符串
     * @param num
     * @param length
     * @return
     */
    private static String generateBinaryStr(int num, int length){
        String str = Integer.toBinaryString(num);
        if (str.length() < length){
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < length - str.length(); i ++){
                builder.append("0");
            }
            str = builder.append(str).toString();
        }
        return str;
    }

    /**
     * 判断子序列是否递增
     * @param tempList
     * @return
     */
    private static boolean isAsc(List<Integer> tempList){
        for (int i = 0; i < tempList.size() - 1; i ++){
            if (tempList.get(i + 1) < tempList.get(i)){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断子串是否重复
     * @param resultList
     * @param tempList
     * @return
     */
    private static boolean isDupilate(List<List<Integer>> resultList, List<Integer> tempList){
        for (List<Integer> list: resultList){
            if (Arrays.equals(list.toArray(), tempList.toArray())){
                return true;
            }
        }
        return false;
    }

    /**
     * 根据数组元素生成hash值
     * @param base
     * @param mod
     * @param temp
     * @return
     */
    private static int getHash(int base, int mod, List<Integer> temp) {
        int hashValue = 0;
        for (int x : temp) {
            hashValue = hashValue * base % mod + (x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }
}
