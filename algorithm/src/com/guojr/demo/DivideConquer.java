package com.guojr.demo;

import java.util.Random;

/**
 * Created by guojr on 2017/7/16.
 */
public class DivideConquer {

    private int[] coin;
    public DivideConquer(int[] coin){
        this.coin = coin;
    }
    public static void main(String[] args) {
        int num[] = DivideConquer.createRandomArr(50);
        int result = new DivideConquer(num).FalseCoin(0,num.length-1);
        System.out.println("计算后得出结果位:" + result);
    }

    /**
     * 分治算法 计算假硬币，设假硬币比真硬币轻,n枚硬币中找出假硬币
     * @param low
     * @param high
     * @return
     */
    public int FalseCoin(int low , int high){
        int i,sum1,sum2,sum3,avg;
        sum1 = sum2 = sum3 = 0;

        avg = (high-low)/2+low+1;//加1是为了方便计算

        if((low + 1) == high)
            return coin[low] < coin[high] ? low : high;

        if((high - low + 1)%2 == 0){
            for(i = low; i < avg ; i++)
                sum1 = sum1 + coin[i];

            for(i = avg ; i <= high; i++)
                sum2 = sum2 + coin[i];

            return sum1 > sum2 ? FalseCoin(avg, high) : FalseCoin(low, avg-1);

        }else {
            for(i = low;i< avg-1;i++)
                sum1 += coin[i];

            for (i = avg;i<=high;i++)
                sum2 += coin[i];

            sum3 = coin[avg];

            return (sum1 > sum2) ? FalseCoin(avg, high) :
                    (sum1 < sum2) ? FalseCoin(low,avg-2) :
                        (sum1+sum3 == sum2+sum3) ? avg-1 : 0;
        }
    }

    public static int[] createRandomArr(int n){
        int num[] = new int[n];
        int random = new Random().nextInt(n);
        for(int i = 0; i<num.length ;i++){
            if(i==random)   num[i] = 1;
            else            num[i] = 2;
        }
        System.out.println("随机生成搜索位："+random);
        return num;
    }
}
