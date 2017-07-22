package com.guojr.demo;

import java.util.Arrays;

/**
 * Created by guojr on 2017/7/18.
 */
public class SortBase {

    /**
     * 简单选择排序
     * @param arr
     */
    public static void selectSort(int[] arr){
        int index,temp;
        for(int i = 0; i < arr.length - 1; i++){
            index = i;
            for(int j = i+1; j < arr.length; j++)
                if(arr[j] < arr[index]) index = j;
            if(index != i){
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 简单插入排序
     * @param arr
     */
    public static void insertionSort(int arr[]){
        int temp,index;
        for(int i = 1; i < arr.length; i++){
            temp = arr[i];
            index = i-1;
            while(index >= 0 && temp < arr[index]){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = temp;
        }
    }


    /**
     * shell排序，又称希尔排序或缩小增量排序
     * 由于插入排序是，如果序列已经是基本有序地，会提高排序效率
     * @param arr
     */
    public static void shellSort(int arr[]){
        int index,temp;
        for(int i = arr.length/2; i >= 1;i/=2){
            for (int j=i; j < arr.length; j++){
                temp = arr[i];
                index = j-i;
                while (index >= 0 && temp < arr[index]){
                    arr[index+i] = arr[index];
                    index -= i;
                }
                arr[index + i] = temp;
            }
        }
    }

    /**
     * 五十万数据选择排序用时 101938，冒泡排序用时 438540！,插入排序用时 30230   ,shell排序用时 24001
     * 五万条数据选择排序用时 1485,   冒泡排序用时 4486,    插入排序用时 308     ,shell排序用时 235
     * @param arr
     * @param flag
     */
    public static void executeSelectSort(int[] arr,boolean flag){
        int[] arr1,arr2,arr3,arr4;
        long beginTime = System.currentTimeMillis();
        arr1 = Arrays.copyOf(arr,arr.length);
        arr2 = Arrays.copyOf(arr,arr.length);
        arr3 = Arrays.copyOf(arr,arr.length);
        arr4 = Arrays.copyOf(arr,arr.length);
        System.out.println("复制数组用时："+(System.currentTimeMillis() - beginTime));

        long beginTime4 = System.currentTimeMillis();
        SortBase.insertionSort(arr4);
        System.out.println("shell排序用时："+(System.currentTimeMillis() - beginTime4));

        long beginTime2 = System.currentTimeMillis();
        SortBase.insertionSort(arr2);
        System.out.println("插入排序用时："+(System.currentTimeMillis() - beginTime2));

        long beginTime1 = System.currentTimeMillis();
        selectSort(arr1);
        System.out.println("选择排序用时："+(System.currentTimeMillis() - beginTime1));

        long beginTime3 = System.currentTimeMillis();
        SortBase.bubbleSortOPT(arr3);
        System.out.println("冒泡排序用时："+(System.currentTimeMillis() - beginTime3));

        if(flag){
            System.out.println("选择排序后数组为:");
            for (int i:arr2)
                System.out.print(i+"\t");
        }
    }

    /**
     * 简单冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        int temp;
        for(int i = arr.length-1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 优化冒泡排序，减少排序次数
     * @param arr
     */
    public static void bubbleSortOPT(int[] arr){
        int temp, k, flag;
        flag = k = arr.length-1;
        while (flag != 0){
            k = flag;
            flag = 0;
            for(int i = 0; i < k; i++){
                if(arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag = i;
                }
            }
        }
    }

    public static void executeBubbleSort(int[] arr,boolean flag){
        System.out.println();
        int[] arr1,arr2;
        arr1 = Arrays.copyOf(arr,arr.length);
        arr2 = Arrays.copyOf(arr,arr.length);
        long beginTime1 = System.currentTimeMillis();
        SortBase.bubbleSort(arr1);
        System.out.println("优化前排序用时："+(System.currentTimeMillis() - beginTime1));

        long beginTime2 = System.currentTimeMillis();
        SortBase.bubbleSortOPT(arr2);
        System.out.println("优化后排序用时："+(System.currentTimeMillis() - beginTime2));
        if(flag){
            System.out.println("冒泡排序后数组为:");
            for (int i:arr1)
                System.out.print(i+"\t");
        }
    }

    public static int[] makeArr(int n,boolean flag){
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random()*200+1);
        if(flag){
            System.out.println("冒泡排序前数组为:");
            for (int i:arr)
                System.out.print(i+",");
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = SortBase.makeArr(50000,false);
//        executeBubbleSort(arr,false);
        executeSelectSort(arr,false);
    }

}
