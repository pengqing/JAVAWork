package com.ane56.utils;

import java.text.Format;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Time {
	public static final long SECOND = 1000L;
	  public static final long MINUTE = 60000L;
	  public static final long HOUR = 3600000L;
	  public static final long DAY = 86400000L;
	  public static final long WEEK = 604800000L;
	  public static final String RFC822_FORMAT = "EEE, dd MMM yyyy HH:mm:ss Z";
	  public static final String TIMESTAMP_FORMAT = "yyyyMMddkkmmssSSS";
	  public static final String SHORT_TIMESTAMP_FORMAT = "yyyyMMddkkmm";

	  public static Date getDate(Calendar cal)
	  {
	    Calendar adjustedCal = Calendar.getInstance();

	    adjustedCal.set(1, cal.get(1));
	    adjustedCal.set(2, cal.get(2));
	    adjustedCal.set(5, cal.get(5));
	    adjustedCal.set(11, cal.get(11));
	    adjustedCal.set(12, cal.get(12));
	    adjustedCal.set(13, cal.get(13));
	    adjustedCal.set(14, cal.get(14));

	    return adjustedCal.getTime();
	  }

	  public static Date getDate(TimeZone tz) {
	    Calendar cal = Calendar.getInstance(tz);

	    return getDate(cal);
	  }

	  public static Date getDate(Date date, TimeZone tz) {
	    Calendar cal = Calendar.getInstance(tz);

	    cal.setTime(date);

	    return getDate(cal);
	  }

	  public static String getDescription(long milliseconds) {
	    String s = "";

	    int x = 0;

	    if (milliseconds % 604800000L == 0L) {
	      x = (int)(milliseconds / 604800000L);

	      s = x + " Week";
	    }
	    else if (milliseconds % 86400000L == 0L) {
	      x = (int)(milliseconds / 86400000L);

	      s = x + " Day";
	    }
	    else if (milliseconds % 3600000L == 0L) {
	      x = (int)(milliseconds / 3600000L);

	      s = x + " Hour";
	    }
	    else if (milliseconds % 60000L == 0L) {
	      x = (int)(milliseconds / 60000L);

	      s = x + " Minute";
	    }
	    else if (milliseconds % 1000L == 0L) {
	      x = (int)(milliseconds / 1000L);

	      s = x + " Second";
	    }

	    if (x > 1) {
	      s = s + "s";
	    }

	    return s;
	  }

	  public static String getRFC822() {
	    return getRFC822(new Date());
	  }

	  public static String getRFC822(Date date) {
	    return getSimpleDate(date, "EEE, dd MMM yyyy HH:mm:ss Z");
	  }

	  public static String getShortTimestamp() {
	    return getShortTimestamp(new Date());
	  }

	  public static String getShortTimestamp(Date date) {
	    return getSimpleDate(date, "yyyyMMddkkmm");
	  }

	  public static String getSimpleDate(Date date, String format) {
	    String s = "";

	    if (date != null) {
	      Format dateFormat = DateUtil.getDateFormat(format);

	      s = dateFormat.format(date);
	    }

	    return s;
	  }

	  public static String getTimestamp() {
	    return getTimestamp(new Date());
	  }

	  public static String getTimestamp(Date date) {
	    return getSimpleDate(date, "yyyyMMddkkmmssSSS");
	  }
}
