package com.ane56.utils;

public class ObjectUtils 
{
	/**
     * 					�Ƚ����������Ƿ����
     * @param actual	the object actual
     * @param expected	the object expected
     * @return			
     *         ����������Ϊnull���򷵻�true
     *         ����Ϊnull������ö�����Ӧ��equals(Object)}���������жϣ������жϽ��
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage:  ObjectUtils.isEquals(objectA,objectB);
     */
    public static boolean isEquals(Object actual, Object expected)
    {
        return actual == null ? expected == null : actual.equals(expected);
    }

    /**
     * 					long����ת����Long����
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
     * 					Long����ת����long����
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
     * 					int����ת����Integer����
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
     *					 Integer����ת����int����
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
     * 						�Ƚ�����ֵ�Ĵ�С
     * 						���ڱȽϵĽ��
     * 						v1����v2����1
     * 						v1����v2����0
     * 						v1С��v2����-1
     * 						���ڱȽϵĹ���
     * 						��v1Ϊnull��v2Ϊnull�������
     * 						��v1Ϊnull��v2��Ϊnull����v1С��v2
     * 						��v1��Ϊnull��v2Ϊnull����v1����v2
     * 						��v1��v2����Ϊnull��������v1��compareTo(Object)�жϣ�����Ϊv2
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
