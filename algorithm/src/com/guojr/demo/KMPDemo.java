package com.guojr.demo;

import java.util.Arrays;

/**
 * KMP算法实现
 */
public class KMPDemo {

    /**
     * 计算next值
     * @param str
     * @return
     */
    public static int[] next(char[] str){
        if(str==null) throw new NullPointerException("字符不能为空");
       int[] next = new int[str.length];
       //第一位必为0,前两位相同为1否则0 减少循环次数
       next[0] = 0;
       next[1] = (str[1]==str[0])?1:0;
       for(int i = 2; i<str.length ; i++){
               int sub_len = 0;
               for(int j = i; j>0 ; j--){
                   char[] pre_str = Arrays.copyOfRange(str,0,j); // 前缀 去掉最后一位
                   char[] suf_str = Arrays.copyOfRange(str, i-j+1,i+1); // 后缀 去掉第一位
                   if(Arrays.equals(pre_str,suf_str))
                        sub_len = sub_len < pre_str.length ? pre_str.length:sub_len; // 获取长度最大目标
               }
               next[i] = sub_len;
       }
        return next;
    }

    public static int search(String origin,String module){
        if(origin==null||module==null) throw new NullPointerException("字符串不能为空");
        char o_arr[] = origin.toCharArray() , m_arr[] = module.toCharArray();
        int str_len = origin.length(),sub_len = module.length();
        int i = 0,j = 1;
        int next[] = next(m_arr);
        boolean flag = false;
        while(true){
            if(i > str_len - 1) return -1;
            if(o_arr[i] == m_arr[j-1]){
                if(j == sub_len )
                    return i-j+1;
                if(!flag)flag=!flag;
                i++; j++;
                continue;
            }
            else{
                if(flag){
                    flag = !flag;
                    //移动位数=已匹配数-匹配值; i-j+(j-next[j-1-1])
                    i = i - next[--j-1];
                    j=1;
                }else{
                    i++;
                }
            }
        }

    }
    public static void main(String[] args) {
        System.out.println(search("bbc abcdab abcdabcdabde","abcdabd"));
    }
}
