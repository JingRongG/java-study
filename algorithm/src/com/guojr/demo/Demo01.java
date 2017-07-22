package com.guojr.demo;
import static java.lang.System.out;

/**
 * 算法基础
 * @author guojingrong
 *
 */
public class Demo01 {
	public Demo01() {}

	/**
	 * 蒙特卡洛π算法
	 * @param n
	 * @return
	 */
	private double MontePI(Integer n){
		double PI;
		double x,y;
		int i,sum = 0;
		for(i=1;i<n;i++)
			if((Math.pow(Math.random(),2)+Math.pow(Math.random(),2)) <=1 )
				sum++;
		PI = 4.0*sum/n;
		return PI;
	}

	/**
	 * 累加
	 * 计算1+2+3+4+...+n的值
	 * @param n
	 */
	@SuppressWarnings("unused")
	private void SumNum(Integer n){
		int iLoop = 1 , iSum = 0 , num = (int) n;
		while(iLoop <= num){
			iSum += iLoop;
			++iLoop;
		}
		out.printf("1到%d的累加和是:%d", n, iSum);
	}

	/**
	 * 奇分数累加
	 * 计算1+1/3+1/5+1/7+...+1/(2*n+1)的值,当1/(2*n+1)小于target时结束
	 * @param target
	 */
	@SuppressWarnings("unused")
	private void SumOddFraction(Double target){
		int initialValue = 1;
		double dSum = 1.0 , dTemp , t = (double) target;
		do{
			dTemp = 1.0/(2*initialValue+1);
//			out.printf("执行参数dSum%f , dTemp%f \n", dSum,dTemp);
			dSum += dTemp;
			initialValue ++;
		}while(dTemp >= t);
		out.printf("运算次数为：%d \n", initialValue-1);
		out.printf("累加和为：%f \n", dSum);
	}

	/**
	 * 打印32-126之间的ASCII码
	 */
	@SuppressWarnings("unused")
	private void ShowAscii(){
		String temp = "";
		for (int i = 32; i <= 126; i++) {
			temp = i<100?("0"+i):(""+i);
			out.print(temp+" = "+(char)i+"	");
			if((i-31)%8 == 0)out.print("\n\n");
		}
	}

	/**
	 * 枚举求毕业人数和就业人数
	 * 假设某学校毕业人数为300人左右，就业率为83.23%，预求出最可能的学生人数及就业人数
	 * 假设总人数为三百人左右的描述，指人数波动为20上下
	 * @param iNum 假设大概人数
	 * @param iOff 波动范围
	 * @param fPercent 就业率
	 */
	private void calcByEnum(Integer iNum,Integer iOff,Float fPercent){
		float fMinDiff = 1.0f, fTmp;
		int iRealNum = 300;
		for (int i = (iNum - iOff); i < (iNum + iOff); i++) {
			fTmp = Math.abs(Math.round(i*fPercent)/(float)i - (float)fPercent);
			if(fTmp < fMinDiff){
				fMinDiff = fTmp;
				iRealNum = i;
			}
		}
		int iJiuYe = Math.round(iRealNum*fPercent);
		out.println("枚举后，获得总人数为：" + iRealNum);
		out.println("已就业人数为：" + iJiuYe);
		out.println("问题陈述给出的就业率为：" + fPercent*100 + "%");
		out.println("枚举得到的就业率为：" + (iJiuYe/(float)iRealNum)*100 + "%");
	}

	/**
	 * 打印九九乘法表
	 */
	@SuppressWarnings("unused")
	private void PrintChengFaBiao(){
		out.println("九九乘法表");
		int i,j;
		for(i = 1;i <= 9;i++){
			for(j = 1;j <= i;j++)
				out.printf("%d*%d=%d\t", i,j,i*j);
			out.println();
		}
	}

	/**
	 * 打印1-n以内的素数
	 * 素数又称质数，指大于一的自然数中除了一和本身外无法被其他自然数整除的数
	 * 大于一的自然数若不是素数，则称之为合数
	 * @param n
	 */
	private void PrintPrimes(Integer n){
		boolean isPrime = true;
		int iCount = 0;
		out.printf("1-%d之间的素数有：\n",n);
		for (int i = 1; i <= n; i++) {
			isPrime = true;
			for(int j = 2; j <= i/2; j++){
				if(i%j == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				out.print(i + "\t");
				iCount ++;
				if(iCount%6 == 0)out.println();
			}
		}
	}

	/**
	 * 打印传入字符串中的汉字Unicode编码
	 * 汉字的unicode编码范围为19968～40869；共20902个
	 * @param str
	 */
	private void queryStrByUnicode(String str){
		out.printf("收到的字符串为：\n%s\n计算后的Unicode编码为：\n", str);
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(c < 19968 || c > 40869)continue;
			out.print((int)c + " ");
		}
	}

	/**
	 * 简单阶乘
	 * @param n
	 * @return
	 */
	private long fact(Integer n){
		if(n <= 1)return 1;
		else return n * fact(n - 1);
	}

}
