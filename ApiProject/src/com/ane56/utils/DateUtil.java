package com.ane56.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateUtil {

	/**
	 * ��ȡSimpleDateFormat
	 * @param parttern ���ڸ�ʽ
	 * @return SimpleDateFormat����
	 * @throws RuntimeException �쳣���Ƿ����ڸ�ʽ
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: SimpleDateFormat demo = DateUtil.getDateFormat("yyyy-MM-dd HH:mm:ss");
	 */
	public static SimpleDateFormat getDateFormat(String parttern) throws RuntimeException {
		return new SimpleDateFormat(parttern);
	}

	/**
	 * ��ȡ�����е�ĳ��ֵ�����ȡ�·�
	 * @param date ����
	 * @param dateType ���ڸ�ʽ
	 * @return ��ֵ
	 * @author techie_zhu 
	 * Created By Techie Zhu [2014-11-19]
	 * Usage:  int a = DateUtil.getInteger(new Date(),0);
	 */
	private static int getInteger(Date date, int dateType) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(dateType);
	}
	
	/**
	 * ����������ĳ���͵�ĳ��ֵ������������
	 * @param date �����ַ���
	 * @param dateType ����
	 * @param amount ��ֵ
	 * @return ����������ַ���
	 * @author techie_zhu 
	 * Created By Techie Zhu [2014-11-19]
	 * Usage:  String temp = DateUtil.addInteger(new Date(),2,34);
	 */
	private static String addInteger(String date, int dateType, int amount) {
		String dateString = null;
		DateStyle dateStyle = getDateStyle(date);
		if (dateStyle != null) {
			Date myDate = StringToDate(date, dateStyle);
			myDate = addInteger(myDate, dateType, amount);
			dateString = DateToString(myDate, dateStyle);
		}
		return dateString;
	}
	
	/**
	 * ����������ĳ���͵�ĳ��ֵ������������
	 * @param date ����
	 * @param dateType ����
	 * @param amount ��ֵ
	 * @return ���������
	 * @author techie_zhu 
	 * Created By Techie Zhu [2014-11-19]
	 * Usage:  Date date = DateUtil.addInteger(new Date(),2,33);
	 */
	private static Date addInteger(Date date, int dateType, int amount) {
		Date myDate = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(dateType, amount);
			myDate = calendar.getTime();
		}
		return myDate;
	}

	/**
	 * ��ȡ��ȷ������
	 * @param timestamps ʱ��long����
	 * @return ����
	 * @author techie_zhu 
	 * Created By Techie Zhu [2014-11-19]
	 * Usage:   List<long> list = new ArrayList<long>();
	 *          list.add(233);
	 *          Date date = DateUtil.getAccurateDate(list);
	 */
	private static Date getAccurateDate(List<Long> timestamps) {
		Date date = null;
		long timestamp = 0;
		Map<Long, long[]> map = new HashMap<Long, long[]>();
		List<Long> absoluteValues = new ArrayList<Long>();

		if (timestamps != null && timestamps.size() > 0) {
			if (timestamps.size() > 1) {
				for (int i = 0; i < timestamps.size(); i++) {
					for (int j = i + 1; j < timestamps.size(); j++) {
						long absoluteValue = Math.abs(timestamps.get(i) - timestamps.get(j));
						absoluteValues.add(absoluteValue);
						long[] timestampTmp = { timestamps.get(i), timestamps.get(j) };
						map.put(absoluteValue, timestampTmp);
					}
				}

				// �п�������ȵ��������2012-11��2012-11-01��ʱ�������ȵ�
				long minAbsoluteValue = -1;
				if (!absoluteValues.isEmpty()) {
					// ���timestamps��sizeΪ2�����ǲ�ֵֻ��һ�������Ҫ��Ĭ��ֵ
					minAbsoluteValue = absoluteValues.get(0);
				}
				for (int i = 0; i < absoluteValues.size(); i++) {
					for (int j = i + 1; j < absoluteValues.size(); j++) {
						if (absoluteValues.get(i) > absoluteValues.get(j)) {
							minAbsoluteValue = absoluteValues.get(j);
						} else {
							minAbsoluteValue = absoluteValues.get(i);
						}
					}
				}

				if (minAbsoluteValue != -1) {
					long[] timestampsLastTmp = map.get(minAbsoluteValue);
					if (absoluteValues.size() > 1) {
						timestamp = Math.max(timestampsLastTmp[0], timestampsLastTmp[1]);
					} else if (absoluteValues.size() == 1) {
						// ��timestamps��sizeΪ2����Ҫ�뵱ǰʱ����Ϊ����
						long dateOne = timestampsLastTmp[0];
						long dateTwo = timestampsLastTmp[1];
						if ((Math.abs(dateOne - dateTwo)) < 100000000000L) {
							timestamp = Math.max(timestampsLastTmp[0], timestampsLastTmp[1]);
						} else {
							long now = new Date().getTime();
							if (Math.abs(dateOne - now) <= Math.abs(dateTwo - now)) {
								timestamp = dateOne;
							} else {
								timestamp = dateTwo;
							}
						}
					}
				}
			} else {
				timestamp = timestamps.get(0);
			}
		}

		if (timestamp != 0) {
			date = new Date(timestamp);
		}
		return date;
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ�����ַ���
	 * @param date �����ַ���
	 * @return true or false
	 * @author techie_zhu 
	 * Created By Techie Zhu [2014-11-19]
	 * Usage:  boolean blnFlag = DateUtil.isDate("2014-11-19");
	 */
	public static boolean isDate(String date) {
		boolean isDate = false;
		if (date != null) {
			if (StringToDate(date) != null) {
				isDate = true;
			}
		}
		return isDate;
	}

	/**
	 * ��ȡ�����ַ��������ڷ��ʧ������null��
	 * @param date �����ַ���
	 * @return ���ڷ��
	 * @author techie_zhu 
	 * Created By Techie Zhu [2014-11-19]
	 * Usage:  DateStyle style = DateUtil.getDateStyle("2014-11-19");
	 */
	public static DateStyle getDateStyle(String date) {
		DateStyle dateStyle = null;
		Map<Long, DateStyle> map = new HashMap<Long, DateStyle>();
		List<Long> timestamps = new ArrayList<Long>();
		for (DateStyle style : DateStyle.values()) {
			Date dateTmp = StringToDate(date, style.getValue());
			if (dateTmp != null) {
				timestamps.add(dateTmp.getTime());
				map.put(dateTmp.getTime(), style);
			}
		}
		dateStyle = map.get(getAccurateDate(timestamps).getTime());
		return dateStyle;
	}

	/**
	 * �������ַ���ת��Ϊ���ڡ�ʧ�ܷ���null��
	 * @param date �����ַ���
	 * @return ����
	 * @author techie_zhu 
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: Date date = DateUtil.StringToDate("2014-11-19");
	 */
	public static Date StringToDate(String date) {
		DateStyle dateStyle = null;
		return StringToDate(date, dateStyle);
	}

	/**
	 * �������ַ���ת��Ϊ���ڡ�ʧ�ܷ���null��
	 * @param date �����ַ���
	 * @param parttern ���ڸ�ʽ
	 * @return ����
	 * @author techie_zhu 
	 * Created By Techie [2014-11-19]
	 * Usage:  Date date = DateUtil.StringToDate("2014-11-11","yyyy-MM-dd");
	 */
	public static Date StringToDate(String date, String parttern) {
		Date myDate = null;
		if (date != null) {
			try {
				myDate = getDateFormat(parttern).parse(date);
			} catch (Exception e) {
			}
		}
		return myDate;
	}

	/**
	 * �������ַ���ת��Ϊ���ڡ�ʧ�ܷ���null��
	 * @param date �����ַ���
	 * @param dateStyle ���ڷ��
	 * @return ����
	 * @author techie_zhu 
	 * Created By Techie Zhu [2014-11-19]
	 * Usage:  Date date = DateUtil.StringToDate("2014-11-19",DateStyle.YYYY_MM_DD);
	 */
	public static Date StringToDate(String date, DateStyle dateStyle) {
		Date myDate = null;
		if (dateStyle == null) {
			List<Long> timestamps = new ArrayList<Long>();
			for (DateStyle style : DateStyle.values()) {
				Date dateTmp = StringToDate(date, style.getValue());
				if (dateTmp != null) {
					timestamps.add(dateTmp.getTime());
				}
			}
			myDate = getAccurateDate(timestamps);
		} else {
			myDate = StringToDate(date, dateStyle.getValue());
		}
		return myDate;
	}

	/**
	 * ������ת��Ϊ�����ַ�����ʧ�ܷ���null��
	 * @param date ����
	 * @param parttern ���ڸ�ʽ
	 * @return �����ַ���
	 * @author techie_zhu 
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: String temp = DateUtil.DateToString(new Date(),"yyyy-MM-dd");
	 */
	public static String DateToString(Date date, String parttern) {
		String dateString = null;
		if (date != null) {
			try {
				dateString = getDateFormat(parttern).format(date);
			} catch (Exception e) {
			}
		}
		return dateString;
	}

	/**
	 * ������ת��Ϊ�����ַ�����ʧ�ܷ���null��
	 * @param date ����
	 * @param dateStyle ���ڷ��
	 * @return �����ַ���
	 * @author techie_zhu 
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: String temp = DateUtil.DateToString(new Date(),DateStyle.YYYY_MM_DD);
	 */
	public static String DateToString(Date date, DateStyle dateStyle) {
		String dateString = null;
		if (dateStyle != null) {
			dateString = DateToString(date, dateStyle.getValue());
		}
		return dateString;
	}

	/**
	 * �������ַ���ת��Ϊ��һ�����ַ�����ʧ�ܷ���null��
	 * @param date �������ַ���
	 * @param parttern �����ڸ�ʽ
	 * @return �������ַ���
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage:  String temp = DateUtil.StringToString("2014-11-19","yyyy-MM-dd");
	 */
	public static String StringToString(String date, String parttern) {
		return StringToString(date, null, parttern);
	}

	/**
	 * �������ַ���ת��Ϊ��һ�����ַ�����ʧ�ܷ���null��
	 * @param date �������ַ���
	 * @param dateStyle �����ڷ��
	 * @return �������ַ���
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: String temp = DateUtil.StringToString("2014-11-19 13:09:09",DateStyle.YYYY_MM_DD);
	 */
	public static String StringToString(String date, DateStyle dateStyle) {
		return StringToString(date, null, dateStyle);
	}

	/**
	 * �������ַ���ת��Ϊ��һ�����ַ�����ʧ�ܷ���null��
	 * @param date �������ַ���
	 * @param olddParttern �����ڸ�ʽ
	 * @param newParttern �����ڸ�ʽ
	 * @return �������ַ���
	 * @author techie_zhu 
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: String temp = DateUtil.StringToString("2014-11-19","yyyy-MM-dd","yyyy-MM-dd HH:mm:ss");
	 */
	public static String StringToString(String date, String olddParttern, String newParttern) {
		String dateString = null;
		if (olddParttern == null) {
			DateStyle style = getDateStyle(date);
			if (style != null) {
				Date myDate = StringToDate(date, style.getValue());
				dateString = DateToString(myDate, newParttern);
			}
		} else {
			Date myDate = StringToDate(date, olddParttern);
			dateString = DateToString(myDate, newParttern);
		}
		return dateString;
	}

	/**
	 * �������ַ���ת��Ϊ��һ�����ַ�����ʧ�ܷ���null��
	 * @param date �������ַ���
	 * @param olddDteStyle �����ڷ��
	 * @param newDateStyle �����ڷ��
	 * @return �������ַ���
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: String temp = DateUtil.StringToString("2014-11-19",DateStyle.YYYY_MM_DD,DateStyle.YYYY_MM_DD_HH_MM_SS);
	 */
	public static String StringToString(String date, DateStyle olddDteStyle, DateStyle newDateStyle) {
		String dateString = null;
		if (olddDteStyle == null) {
			DateStyle style = getDateStyle(date);
			dateString = StringToString(date, style.getValue(), newDateStyle.getValue());
		} else {
			dateString = StringToString(date, olddDteStyle.getValue(), newDateStyle.getValue());
		}
		return dateString;
	}

	/**
	 * �������ڵ���ݡ�ʧ�ܷ���null��
	 * @param date ����
	 * @param yearAmount ������������Ϊ����
	 * @return ������ݺ�������ַ���
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: String temp = DateUtil.addYear("2014-11-19",2);
	 */
	public static String addYear(String date, int yearAmount) {
		return addInteger(date, Calendar.YEAR, yearAmount);
	}
	
	/**
	 * �������ڵ���ݡ�ʧ�ܷ���null��
	 * @param date ����
	 * @param yearAmount ������������Ϊ����
	 * @return ������ݺ������
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: Date date = DateUtil.addYear(new Date(),2);
	 */
	public static Date addYear(Date date, int yearAmount) {
		return addInteger(date, Calendar.YEAR, yearAmount);
	}
	
	/**
	 * �������ڵ��·ݡ�ʧ�ܷ���null��
	 * @param date ����
	 * @param yearAmount ������������Ϊ����
	 * @return �����·ݺ�������ַ���
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: String temp = DateUtil.addMonth("2014-11-19",2);
	 */
	public static String addMonth(String date, int yearAmount) {
		return addInteger(date, Calendar.MONTH, yearAmount);
	}
	
	/**
	 * �������ڵ��·ݡ�ʧ�ܷ���null��
	 * @param date ����
	 * @param yearAmount ������������Ϊ����
	 * @return �����·ݺ������
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: Date date = DateUtil.addMonth(new Date(),3);
	 */
	public static Date addMonth(Date date, int yearAmount) {
		return addInteger(date, Calendar.MONTH, yearAmount);
	}
	
	/**
	 * �������ڵ�������ʧ�ܷ���null��
	 * @param date �����ַ���
	 * @param dayAmount ������������Ϊ����
	 * @return ����������������ַ���
	 * @author techie_zhu
	 * Usage: String temp = DateUtil.addDay("2014-11-19",3);
	 */
	public static String addDay(String date, int dayAmount) {
		return addInteger(date, Calendar.DATE, dayAmount);
	}

	/**
	 * �������ڵ�������ʧ�ܷ���null��
	 * @param date ����
	 * @param dayAmount ������������Ϊ����
	 * @return ���������������
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: Date date = DateUtil.addDay(new Date(),3);
	 */
	public static Date addDay(Date date, int dayAmount) {
		return addInteger(date, Calendar.DATE, dayAmount);
	}
	
	/**
	 * �������ڵ�Сʱ��ʧ�ܷ���null��
	 * @param date �����ַ���
	 * @param dayAmount ������������Ϊ����
	 * @return ����Сʱ��������ַ���
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: String temp = DateUtil.addHour("2014-11-19 18:40:22",3);
	 */
	public static String addHour(String date, int hourAmount) {
		return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
	}

	/**
	 * �������ڵ�Сʱ��ʧ�ܷ���null��
	 * @param date ����
	 * @param dayAmount ������������Ϊ����
	 * @return ����Сʱ�������
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: Date date = DateUtil.addHour(new Date(),3);
	 */
	public static Date addHour(Date date, int hourAmount) {
		return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
	}
	
	/**
	 * �������ڵķ��ӡ�ʧ�ܷ���null��
	 * @param date �����ַ���
	 * @param dayAmount ������������Ϊ����
	 * @return ���ӷ��Ӻ�������ַ���
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage:��String temp = DateUtil.addMinute("2014-11-11 12:33:23",33);
	 */
	public static String addMinute(String date, int hourAmount) {
		return addInteger(date, Calendar.MINUTE, hourAmount);
	}

	/**
	 * �������ڵķ��ӡ�ʧ�ܷ���null��
	 * @param date ����
	 * @param dayAmount ������������Ϊ����
	 * @return ���ӷ��Ӻ������
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19 11:33:22",33);
	 */
	public static Date addMinute(Date date, int hourAmount) {
		return addInteger(date, Calendar.MINUTE, hourAmount);
	}
	
	/**
	 * �������ڵ����ӡ�ʧ�ܷ���null��
	 * @param date �����ַ���
	 * @param dayAmount ������������Ϊ����
	 * @return �������Ӻ�������ַ���
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage:��String temp = DateUtil.addSecond("2014-11-19 12:22:33",34);
	 */
	public static String addSecond(String date, int hourAmount) {
		return addInteger(date, Calendar.SECOND, hourAmount);
	}

	/**
	 * �������ڵ����ӡ�ʧ�ܷ���null��
	 * @param date ����
	 * @param dayAmount ������������Ϊ����
	 * @return �������Ӻ������
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: Date date = DateUtil.addSecond(new Date(),33);
	 */
	public static Date addSecond(Date date, int hourAmount) {
		return addInteger(date, Calendar.SECOND, hourAmount);
	}

	/**
	 * ��ȡ���ڵ���ݡ�ʧ�ܷ���0��
	 * @param date �����ַ���
	 * @return ���
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: int intYear = DateUtil.getYear("2014-11-19");
	*/
	public static int getYear(String date) {
		return getYear(StringToDate(date));
	}

	/**
	 * ��ȡ���ڵ���ݡ�ʧ�ܷ���0��
	 * @param date ����
	 * @return ���
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage:��int intYear = DateUtil.getYear(new Date());
	 */
	public static int getYear(Date date) {
		return getInteger(date, Calendar.YEAR);
	}

	/**
	 * ��ȡ���ڵ��·ݡ�ʧ�ܷ���0��
	 * @param date �����ַ���
	 * @return �·�
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: int intMonth = DateUtil.getMonth("2014-11-19");
	 */
	public static int getMonth(String date) {
		return getMonth(StringToDate(date));
	}

	/**
	 * ��ȡ���ڵ��·ݡ�ʧ�ܷ���0��
	 * @param date ����
	 * @return �·�
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage : int intMonth = DateUtil.getMonth(new Date());
	 */
	public static int getMonth(Date date) {
		return getInteger(date, Calendar.MONTH);
	}

	/**
	 * ��ȡ���ڵ�������ʧ�ܷ���0��
	 * @param date �����ַ���
	 * @return ��
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: int intDay = DateUtil.getDay("2014-11-19");
	 */
	public static int getDay(String date) {
		return getDay(StringToDate(date));
	}

	/**
	 * ��ȡ���ڵ�������ʧ�ܷ���0��
	 * @param date ����
	 * @return ��
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: int intDay = DateUtil.getDay(new Date());
	 */
	public static int getDay(Date date) {
		return getInteger(date, Calendar.DATE);
	}
	
	/**
	 * ��ȡ���ڵ�Сʱ��ʧ�ܷ���0��
	 * @param date �����ַ���
	 * @return Сʱ
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: int intHour = DateUtil.getHour("2014-11-19 12:23:33");
	 */
	public static int getHour(String date) {
		return getHour(StringToDate(date));
	}

	/**
	 * ��ȡ���ڵ�Сʱ��ʧ�ܷ���0��
	 * @param date ����
	 * @return Сʱ
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: int intHour = DateUtil.getHour(new Date());
	 */
	public static int getHour(Date date) {
		return getInteger(date, Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * ��ȡ���ڵķ��ӡ�ʧ�ܷ���0��
	 * @param date �����ַ���
	 * @return ����
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: int intMinute = DateUtil.getMinute("2014-11-19 12:22:11");
	 */
	public static int getMinute(String date) {
		return getMinute(StringToDate(date));
	}

	/**
	 * ��ȡ���ڵķ��ӡ�ʧ�ܷ���0��
	 * @param date ����
	 * @return ����
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: int intMinute = DateUtil.getMinute(new Date());
	 */
	public static int getMinute(Date date) {
		return getInteger(date, Calendar.MINUTE);
	}
	
	/**
	 * ��ȡ���ڵ����ӡ�ʧ�ܷ���0��
	 * @param date �����ַ���
	 * @return ����
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: int intSecond = DateUtil.getSecond("2014-11-19 12:22:11");
	 */
	public static int getSecond(String date) {
		return getSecond(StringToDate(date));
	}

	/**
	 * ��ȡ���ڵ����ӡ�ʧ�ܷ���0��
	 * @param date ����
	 * @return ����
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: int intSecond = DateUtil.getSecond(new Date());
	 */
	public static int getSecond(Date date) {
		return getInteger(date, Calendar.SECOND);
	}

	/**
	 * ��ȡ���� ��Ĭ��yyyy-MM-dd��ʽ��ʧ�ܷ���null��
	 * @param date �����ַ���
	 * @return ����
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: String temp = DateUtil.getDate("2014-11-19");
	 */
	public static String getDate(String date) {
		return StringToString(date, DateStyle.YYYY_MM_DD);
	}

	/**
	 * ��ȡ���ڡ�Ĭ��yyyy-MM-dd��ʽ��ʧ�ܷ���null��
	 * @param date ����
	 * @return ����
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: String temp = DateUtil.getDate(new Date());
	 */
	public static String getDate(Date date) {
		return DateToString(date, DateStyle.YYYY_MM_DD);
	}

	/**
	 * ��ȡ���ڵ�ʱ�䡣Ĭ��HH:mm:ss��ʽ��ʧ�ܷ���null��
	 * @param date �����ַ���
	 * @return ʱ��
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: String temp = DateUtil.getTime("12:22:33");
	 */
	public static String getTime(String date) {
		return StringToString(date, DateStyle.HH_MM_SS);
	}

	/**
	 * ��ȡ���ڵ�ʱ�䡣Ĭ��HH:mm:ss��ʽ��ʧ�ܷ���null��
	 * @param date ����
	 * @return ʱ��
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: String temp = DateUtil.getTime(new Date());
	 */
	public static String getTime(Date date) {
		return DateToString(date, DateStyle.HH_MM_SS);
	}

	/**
	 * ��ȡ���ڵ����ڡ�ʧ�ܷ���null��
	 * @param date �����ַ���
	 * @return ����
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: Week week = DateUtil.getWeek("2014-11-19");
	 */
	public static Week getWeek(String date) {
		Week week = null;
		DateStyle dateStyle = getDateStyle(date);
		if (dateStyle != null) {
			Date myDate = StringToDate(date, dateStyle);
			week = getWeek(myDate);
		}
		return week;
	}

	/**
	 * ��ȡ���ڵ����ڡ�ʧ�ܷ���null��
	 * @param date ����
	 * @return ����
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: Week week = DateUtil.getWeek(new Date());
	 */
	public static Week getWeek(Date date) {
		Week week = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		switch (weekNumber) {
		case 0:
			week = Week.SUNDAY;
			break;
		case 1:
			week = Week.MONDAY;
			break;
		case 2:
			week = Week.TUESDAY;
			break;
		case 3:
			week = Week.WEDNESDAY;
			break;
		case 4:
			week = Week.THURSDAY;
			break;
		case 5:
			week = Week.FRIDAY;
			break;
		case 6:
			week = Week.SATURDAY;
			break;
		}
		return week;
	}
	
	/**
	 * ��ȡ����������������
	 * @param date �����ַ���
	 * @param otherDate ��һ�������ַ���
	 * @return �������
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: int intDays = DateUtil.getIntervalDays("2014-11-19","2014-11-29");
	 */
	public static int getIntervalDays(String date, String otherDate) {
		return getIntervalDays(StringToDate(date), StringToDate(otherDate));
	}
	
	/**
	 * @param date ����
	 * @param otherDate ��һ������
	 * @return �������
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: int intDays = DateUtil.getIntervalDays(new Date(),new Date("2014-11-10"));
	 */
	public static int getIntervalDays(Date date, Date otherDate) {
		date = DateUtil.StringToDate(DateUtil.getDate(date));
		long time = Math.abs(date.getTime() - otherDate.getTime());
		return (int)time/(24 * 60 * 60 * 1000);
	}
}