package com.guojr.linearlist.sequential;


import org.junit.jupiter.api.Test;

public class SequentialTest {

	@Test
	public void test() {
//		SequentialList list = new SequentialList(50);
//		list.add("1", "张三");
//		list.add("2", "李四");
//		list.add("3", "王五");
//		list.add("4", "狗蛋");
//		System.out.println(list.toString());
//		System.out.println(list.getValue(1));
//		System.out.println(list.getValue("3"));
//		list.insert("0", "小明", 0);
//		System.out.println(list.toString());
//		list.delete(5);
//		System.out.println(list.toString());
		long start = System.currentTimeMillis();
		SequentialList list = new SequentialList(1000000);
		for (int i = 0; i < 1000000; i++) 
			list.add(""+(i+1), "testData"+(i+1));
		System.out.println("用时："+(System.currentTimeMillis() - start));
	}

}
