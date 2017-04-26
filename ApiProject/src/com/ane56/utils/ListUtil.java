package com.ane56.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections.list.UnmodifiableList;

public class ListUtil {
	public static <E> List<E> copy(List<E> master)
	  {
	    if (master == null) {
	      return null;
	    }

	    return new ArrayList(master);
	  }

	  public static <E> void copy(List<E> master, List<? super E> copy) {
	    if ((master == null) || (copy == null)) {
	      return;
	    }

	    copy.clear();

	    copy.addAll(master);
	  }

	  public static void distinct(List<?> list) {
	    distinct(list, null);
	  }

	  public static <E> void distinct(List<E> list, Comparator<E> comparator) {
	    if ((list == null) || (list.isEmpty())) {
	      return;
	    }

	    Set set = null;

	    if (comparator == null) {
	      set = new TreeSet();
	    }
	    else {
	      set = new TreeSet(comparator);
	    }

	    Iterator itr = list.iterator();

	    while (itr.hasNext()) {
	      Object obj = itr.next();

	      if (set.contains(obj)) {
	        itr.remove();
	      }
	      else
	        set.add(obj);
	    }
	  }

	  public static <E> List<E> fromArray(E[] array)
	  {
	    if ((array == null) || (array.length == 0)) {
	      return new ArrayList();
	    }

	    return new ArrayList(Arrays.asList(array));
	  }

	  public static <E> List<E> fromCollection(Collection<E> c)
	  {
	    if ((c != null) && (List.class.isAssignableFrom(c.getClass()))) {
	      return (List)c;
	    }

	    if ((c == null) || (c.isEmpty())) {
	      return new ArrayList();
	    }

	    List list = new ArrayList(c.size());

	    list.addAll(c);

	    return list;
	  }

	  public static <E> List<E> fromEnumeration(Enumeration<E> enu) {
	    List list = new ArrayList();

	    while (enu.hasMoreElements()) {
	      Object obj = enu.nextElement();

	      list.add(obj);
	    }

	    return list;
	  }

	  public static <E> List<E> sort(List<E> list) {
	    return sort(list, null);
	  }

	  public static <E> List<E> sort(List<E> list, Comparator<? super E> comparator)
	  {
	    if (UnmodifiableList.class.isAssignableFrom(list.getClass())) {
	      list = copy(list);
	    }

	    Collections.sort(list, comparator);

	    return list;
	  }

	  public static <E> List<E> subList(List<E> list, int start, int end) {
	    List newList = new ArrayList();

	    int normalizedSize = list.size() - 1;

	    if ((start < 0) || (start > normalizedSize) || (end < 0) || 
	      (start > end))
	    {
	      return newList;
	    }

	    for (int i = start; (i < end) && (i <= normalizedSize); i++) {
	      newList.add(list.get(i));
	    }

	    return newList;
	  }

	  public static List<Boolean> toList(boolean[] array) {
	    if ((array == null) || (array.length == 0)) {
	      return Collections.emptyList();
	    }

	    List list = new ArrayList(array.length);

	    boolean[] arrayOfBoolean = array; int j = array.length; for (int i = 0; i < j; i++) { boolean value = arrayOfBoolean[i];
	      list.add(Boolean.valueOf(value));
	    }

	    return list;
	  }

	  public static List<Double> toList(double[] array) {
	    if ((array == null) || (array.length == 0)) {
	      return Collections.emptyList();
	    }

	    List list = new ArrayList(array.length);

	    double[] arrayOfDouble = array; int j = array.length; for (int i = 0; i < j; i++) { double value = arrayOfDouble[i];
	      list.add(Double.valueOf(value));
	    }

	    return list;
	  }

	  public static <E> List<E> toList(E[] array) {
	    if ((array == null) || (array.length == 0)) {
	      return Collections.emptyList();
	    }

	    return new ArrayList(Arrays.asList(array));
	  }

	  public static List<Float> toList(float[] array) {
	    if ((array == null) || (array.length == 0)) {
	      return Collections.emptyList();
	    }

	    List list = new ArrayList(array.length);

	    float[] arrayOfFloat = array; int j = array.length; for (int i = 0; i < j; i++) { float value = arrayOfFloat[i];
	      list.add(Float.valueOf(value));
	    }

	    return list;
	  }

	  public static List<Integer> toList(int[] array) {
	    if ((array == null) || (array.length == 0)) {
	      return Collections.emptyList();
	    }

	    List list = new ArrayList(array.length);

	    int[] arrayOfInt = array; int j = array.length; for (int i = 0; i < j; i++) { int value = arrayOfInt[i];
	      list.add(Integer.valueOf(value));
	    }

	    return list;
	  }

	  public static List<Long> toList(long[] array) {
	    if ((array == null) || (array.length == 0)) {
	      return Collections.emptyList();
	    }

	    List list = new ArrayList(array.length);

	    long[] arrayOfLong = array; int j = array.length; for (int i = 0; i < j; i++) { long value = arrayOfLong[i];
	      list.add(Long.valueOf(value));
	    }

	    return list;
	  }

	  public static List<Short> toList(short[] array) {
	    if ((array == null) || (array.length == 0)) {
	      return Collections.emptyList();
	    }

	    List list = new ArrayList(array.length);

	    short[] arrayOfShort = array; int j = array.length; for (int i = 0; i < j; i++) { short value = arrayOfShort[i];
	      list.add(Short.valueOf(value));
	    }

	    return list;
	  }
}
