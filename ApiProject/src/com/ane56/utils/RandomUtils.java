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
     * 					�õ��̶����ȵ�����ַ������ַ��������ֺʹ�Сд��ĸ������
     * @param length 	����
     * @return			���ع̶����ȵ�����ַ���
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage: RandomUtils.getRandomNumbersAndLetters(3);
     */
    public static String getRandomNumbersAndLetters(int length)
    {
        return getRandom(NUMBERS_AND_LETTERS, length);
    }

    /**
     * 					�õ��̶����ȵ�����ַ������ַ��������ֻ�����
     * @param length 	����
     * @return			���ع̶����ȵ�����ַ���
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage: RandomUtils.getRandomNumbers(3);
     */
    public static String getRandomNumbers(int length)
    {
        return getRandom(NUMBERS, length);
    }

    /**
     * 					�õ��̶����ȵ�����ַ������ַ����ɴ�Сд��ĸ������
     * @param length 	����
     * @return			���ع̶����ȵ�����ַ���
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage: RandomUtils.getRandomLetters(12);
     */
    public static String getRandomLetters(int length) 
    {
        return getRandom(LETTERS, length);
    }

    /**
     * 					�õ��̶����ȵ�����ַ������ַ����ɴ�д��ĸ������
     * @param length 	����
     * @return			���ع̶����ȵ�����ַ���
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage: RandomUtils.getRandomCapitalLetters(12);
     */
    public static String getRandomCapitalLetters(int length)
    {
        return getRandom(CAPITAL_LETTERS, length);
    }

    /**
     * 						�õ��̶����ȵ�����ַ������ַ�����Сд��ĸ������
     * @param length 		����
     * @return				���ع̶����ȵ�����ַ���
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage: RandomUtils.getRandomLowerCaseLetters(12);
     */
    public static String getRandomLowerCaseLetters(int length)
    {
        return getRandom(LOWER_CASE_LETTERS, length);
    }

    /**
     * 					�õ��̶����ȵ�����ַ������ַ�����source���ַ�������
     * @param source 	Դ�ַ���
     * @param length 	����
     * @return			���ع̶����ȵ�����ַ���
     *         			��sourceΪnull��Ϊ���ַ���������null
     * @author techie_zhu
     * Created By Techie Zhu [2014-12-10]
     * Usage: RandomUtils.getRandom("adb",12);
     */
    public static String getRandom(String source, int length) 
    {
        return source == null ? null : getRandom(source.toCharArray(), length);
    }

    /**
     * 						�õ��̶����ȵ�����ַ������ַ�����sourceChar���ַ�������
     * @param sourceChar 	Դ�ַ�����
     * @param length 		����
     * @return				���ع̶����ȵ�����ַ���
     *						��sourceCharΪnull�򳤶�Ϊ0������null
     *         				��lengthС��0������null
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
