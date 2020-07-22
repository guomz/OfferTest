package com.guomz.OfferTest.min_array;

public class Main {

    public static void main(String[] args) {

        int numbers[] = new int[]{2,2,2,0,1};
        System.out.println(minArray(numbers));
    }

    public static int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0){
            return 0;
        }


        for (int i = 1; i < numbers.length; i ++){
            if (numbers[i] < numbers[i - 1]){
                return numbers[i];
            }
        }

        return numbers[0];
    }
}
