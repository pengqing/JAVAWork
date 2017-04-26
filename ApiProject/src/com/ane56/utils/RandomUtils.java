package com.ane56.utils;

import java.util.Random;

public class RandomUtils {

    public static final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS             = "0123456789";
    public static final String LETTERS             = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String CAPITAL_LETTERS     = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_CASE_LETTERS  = "abcdefghijklmnopqrstuvwxyz";
    
    public static long getLongValue()
    {
    	long lngValue = 0L;
    	long temp = new Random().nextLong();    	
    	lngValue = Math.abs(temp);
    	if(String.valueOf(lngValue).length()>16)
    	{
    		lngValue = Long.parseLong(String.valueOf(temp).substring(1,16));
    	}
    	return lngValue;
    }
    
    public static String getLongValue(int length) 
    {
    	long lngValue = 0L;
    	long temp = new Random().nextLong();
    	lngValue = Math.abs(temp);
    	if(String.valueOf(lngValue).length()>length)
    	{
    		lngValue = Long.parseLong(String.valueOf(temp).substring(1,length));
    	}
    	
    	return String.valueOf(lngValue);
    }
    /**
     * 					得到固定长度的随机字符串，字符串由数字和大小写字母混合组成
     * @param length 	长度
     * @return			返回固定长度的随机字符串
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage: RandomUtils.getRandomNumbersAndLetters(3);
     */
    public static String getRandomNumbersAndLetters(int length)
    {
        return getRandom(NUMBERS_AND_LETTERS, length);
    }

    /**
     * 					得到固定长度的随机字符串，字符串由数字混合组成
     * @param length 	长度
     * @return			返回固定长度的随机字符串
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage: RandomUtils.getRandomNumbers(3);
     */
    public static String getRandomNumbers(int length)
    {
        return getRandom(NUMBERS, length);
    }

    /**
     * 					得到固定长度的随机字符串，字符串由大小写字母混合组成
     * @param length 	长度
     * @return			返回固定长度的随机字符串
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage: RandomUtils.getRandomLetters(12);
     */
    public static String getRandomLetters(int length) 
    {
        return getRandom(LETTERS, length);
    }

    /**
     * 					得到固定长度的随机字符串，字符串由大写字母混合组成
     * @param length 	长度
     * @return			返回固定长度的随机字符串
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage: RandomUtils.getRandomCapitalLetters(12);
     */
    public static String getRandomCapitalLetters(int length)
    {
        return getRandom(CAPITAL_LETTERS, length);
    }

    /**
     * 						得到固定长度的随机字符串，字符串由小写字母混合组成
     * @param length 		长度
     * @return				返回固定长度的随机字符串
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage: RandomUtils.getRandomLowerCaseLetters(12);
     */
    public static String getRandomLowerCaseLetters(int length)
    {
        return getRandom(LOWER_CASE_LETTERS, length);
    }

    /**
     * 					得到固定长度的随机字符串，字符串由source中字符混合组成
     * @param source 	源字符串
     * @param length 	长度
     * @return			返回固定长度的随机字符串
     *         			若source为null或为空字符串，返回null
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage: RandomUtils.getRandom("adb",12);
     */
    public static String getRandom(String source, int length) 
    {
        return source == null ? null : getRandom(source.toCharArray(), length);
    }

    /**
     * 						得到固定长度的随机字符串，字符串由sourceChar中字符混合组成
     * @param sourceChar 	源字符数组
     * @param length 		长度
     * @return				返回固定长度的随机字符串
     *						若sourceChar为null或长度为0，返回null
     *         				若length小于0，返回null
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage: RandomUtils.getRandom(sourceChar,12);
     */
    public static String getRandom(char[] sourceChar, int length)
    {
        if (sourceChar == null || sourceChar.length == 0 || length < 0) {
            return null;
        }

        StringBuilder str = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            str.append(sourceChar[random.nextInt(sourceChar.length)]);
        }
        return str.toString();
    }
}
