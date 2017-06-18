package com.guojr.linearlist.sequential;

/**
 * 线性表-顺序表
 * 易理解，操作方便
 * 缺点：插入删除数据时需要移动大量数据；
 * 数据量很大时很难分配连续的存储空间，导致内存分配失败 --TODO
 * 
 * @author guojingrong
 *
 */
public class SequentialList {
	private final int DEFAULTLEN = 100;//顺序表默认长度
	private int MAXLEN;				   //当前顺序表最大长度
	private DATA[] listData;		   //数据集
	private int length = 0;			   //当前顺序表长度
	
	/**
	 * 使用默认大小创建表
	 */
	public SequentialList() {
		this.listData = new DATA[DEFAULTLEN];
		MAXLEN = DEFAULTLEN;
	}
	
	/**
	 * 自定义长度
	 * @param len 表长度
	 */
	public SequentialList(int len){
		if(len > 0){
			MAXLEN = len;
			this.listData = new DATA[MAXLEN];
		}
	}
	
	/**
	 * 返回当前表长度
	 * @return
	 */
	public int length(){
		return this.length;
	}
	
	/**
	 * 插入
	 * @param key   数据关键字
	 * @param value 数据可为任何类型
	 * @param index 索引位
	 * @return 返回当前表长度
	 */
	public int insert(String key,Object value,int index){
		if(index >= MAXLEN || index < 0 || index > this.length - 1)
			throw new ArrayIndexOutOfBoundsException(index);
		for (int i = this.length; i >= index; i--) 
			this.listData[i+1] = this.listData[i];
		DATA d = new DATA();
		d.key = key;
		d.value = value;
		this.listData[index] = d;
		this.length ++;
		return 	this.length;
	}
	
	/**
	 * 向末尾添加数据
	 * @param key   数据关键字
	 * @param value 数据可为任何类型
	 * @return		返回当前表长度
	 */
	public int add(String key,Object value){
		if(this.length >= MAXLEN)
			throw new ArrayIndexOutOfBoundsException();
		DATA d = new DATA();
		d.key = key;
		d.value = value;
		this.listData[this.length++] = d;
		return this.length;
	}
	
	/**
	 * 删除数据
	 * 根据索引位删除数据
	 * @param index 索引位
	 * @return
	 */
	public int delete(int index){
		if(index < 0 || index > this.length)
			throw new ArrayIndexOutOfBoundsException(index);
		for(int i = index; i < this.length; i++)
			this.listData[i] = this.listData[i + 1];
		this.length--;
		return 1;
	}
	
	/**
	 * 删除数据
	 * 根据数据关键字删除数据
	 * @param key 关键字
	 */
	public void delete(String key){
		for (int i = 0; i < this.length; i++) 
			if(this.listData[i].key.compareTo(key) == 0)
				this.delete(i);
	}
	
	/**
	 * 获取值
	 * @param index 索引位
	 * @return
	 */
	public Object getValue(int index){
		if(index < 0 || index > this.length)
			throw new ArrayIndexOutOfBoundsException(index);
		return this.listData[index].value;
	}
	
	/**
	 * 获取值
	 * @param key 关键字
	 * @return
	 */
	public Object getValue(String key){
		for (int i = 0; i < this.length; i++) 
			if(this.listData[i].key.compareTo(key) == 0)
				return this.listData[i].value;
		return null;
	}
	
	/**
	 * 获取全部数据
	 * @return 返回包含全部数据的数组
	 */
	public Object[] getValues(){
		Object[] oTemp = new Object[this.length];
		for (int i = 0; i < this.length; i++) 
			oTemp[i] = this.listData[i].value;
		return oTemp;
	}
	
	/**
	 * 获取全部关键字
	 * @return 返回包含全部关键字的数组
	 */
	public Object[] getKeys(){
		Object[] oTemp = new Object[this.length];
		for (int i = 0; i < this.length; i++) 
			oTemp[i] = this.listData[i].key;
		return oTemp;
	}
	
	/**
	 * 将数据转为字符串
	 */
	public String toString(){
		StringBuilder build = new StringBuilder("[\n");
		for (int i = 0; i < this.length; i++)
			build.append("{key:"+this.listData[i].key+",value:"+this.listData[i].value+"} \n");
		build.append("]");
		return build.toString();
	}
	
	public void rest(){
		this.length = 0;
	}
	
	/**
	 * 数据节点类
	 * @author guojingrong
	 *
	 */
	private class DATA{
		String  key	 ;
		Object  value;
	}
	
}
