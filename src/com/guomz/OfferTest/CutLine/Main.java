package com.guomz.OfferTest.CutLine;

public class Main {

    public static void main(String args[])
    {
        int lineLength = 8;
        int arr[] = new int[lineLength + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for(int i = 4; i <= lineLength; i++)
        {
            int maxResult = 0;
            for(int j = 1; j <= i/2; j++)
            {
                int tempResult = arr[j] * arr[i - j];
                if(tempResult > maxResult)
                {
                    maxResult = tempResult;
                }
            }
            arr[i] = maxResult;
        }

        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
