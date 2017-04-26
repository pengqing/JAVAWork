package com.ane56.utils;

public class ObjectUtils 
{
	/**
     * 					比较两个对象是否相等
     * @param actual	the object actual
     * @param expected	the object expected
     * @return			
     *         若两个对象都为null，则返回true
     *         对象不为null，则调用对象相应的equals(Object)}函数进行判断，返回判断结果
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage:  ObjectUtils.isEquals(objectA,objectB);
     */
    public static boolean isEquals(Object actual, Object expected)
    {
        return actual == null ? expected == null : actual.equals(expected);
    }

    /**
     * 					long数组转换成Long数组
     * @param source	the source array.
     * @return			it will return an array with its data type of Long.
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage:  ObjectUtils.transformLongArray(arr);
     */
    public static Long[] transformLongArray(long[] source)
    {
        Long[] destin = new Long[source.length];
        for (int i = 0; i < source.length; i++)
        {
            destin[i] = source[i];
        }
        return destin;
    }

    /**
     * 					Long数组转换成long数组
     * @param source	the source array of Long type.
     * @return			it will return an array with its data type of long.
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage:  ObjectUtils.transformLongArray(arr);
     */
    public static long[] transformLongArray(Long[] source)
    {
        long[] destin = new long[source.length];
        for (int i = 0; i < source.length; i++)
        {
            destin[i] = source[i];
        }
        return destin;
    }

    /**
     * 					int数组转换成Integer数组
     * @param source	the source array of int type.
     * @return			it will return an array with its data type of Integer.
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage:  ObjectUtils.transformIntArray(arr);
     */
    public static Integer[] transformIntArray(int[] source)
    {
        Integer[] destin = new Integer[source.length];
        for (int i = 0; i < source.length; i++)
        {
            destin[i] = source[i];
        }
        return destin;
    }

    /**
     *					 Integer数组转换成int数组
     * @param source	 the source array of Integer type.
     * @return			 it will return an array with its data type of int.
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage:  ObjectUtils.transformIntArray(arr);
     */
    public static int[] transformIntArray(Integer[] source)
    {
        int[] destin = new int[source.length];
        for (int i = 0; i < source.length; i++)
        {
            destin[i] = source[i];
        }
        return destin;
    }

    /**
     * 						比较两个值的大小
     * 						关于比较的结果
     * 						v1大于v2返回1
     * 						v1等于v2返回0
     * 						v1小于v2返回-1
     * 						关于比较的规则
     * 						若v1为null，v2为null，则相等
     * 						若v1为null，v2不为null，则v1小于v2
     * 						若v1不为null，v2为null，则v1大于v2
     * 						若v1、v2均不为null，则利用v1的compareTo(Object)判断，参数为v2
     * @param v1			V1 object
     * @param v2			V2 object.
     * @return				it will return an int value which indicates whether V1 is equal to V2.
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage:  ObjectUtils.compare(v1,v2);
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <V> int compare(V v1, V v2)
    {
        return v1 == null ? (v2 == null ? 0 : -1) : (v2 == null ? 1 : ((Comparable)v1).compareTo(v2));
    }
}
