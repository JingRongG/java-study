package com.guojr.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;

public class Main {
	private String className  = "com.guojr.demo.Demo01";
	private String methodName = "SumNum";
	private Object[] param = new Object[]{100};

	@Test
	public void test() {
//		methodName = "SumOddFraction";
//		param = new Object[]{1.0e-5d};

//		methodName = "ShowAscii";
//		param = null;

//		methodName = "calcByEnum";
//		param = new Object[]{300,20,0.8323f};

//		methodName = "PrintChengFaBiao";
//		param = new Object[]{};

//		methodName = "PrintPrimes";
//		param = new Object[]{100};

//		methodName = "queryStrByUnicode";
//		param = new Object[]{"肏你妈屄"};

//		methodName = "fact";
//		param = new Object[]{12};

		methodName = "MontePI";
		param = new Object[]{Integer.MAX_VALUE};
		try {
			Main.execute(className,methodName,param);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void execute(String className , String methodName , Object[] param) throws Exception{
		out.printf("class is：%s method is：%s param is：%s \n",className,methodName,param.toString());
		Class[] pCls = null;
		Object result;
		if(param != null){
			pCls = new Class[param.length];
			int i = 0;
			for (Object object : param)
				pCls[i++] = object.getClass();
		}
		//获取类
		Class<?> cls = Class.forName(className);
		//获取方法
		Method method = param == null ?
				cls.getDeclaredMethod(methodName) : cls.getDeclaredMethod(methodName,pCls);
		//生成构造器
		Constructor<?> construcotr = cls.getConstructor();
		//压制访问修饰符检查
		method.setAccessible(true);
		//创建实例
		Object demo = construcotr.newInstance();
		//执行方法
		if(param == null)
			result =	method.invoke(demo);
		else
			result =	method.invoke(demo, param);

		if(result != null)
			out.println(result);
	}

}
