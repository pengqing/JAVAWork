package com.ane56.utils;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Randomizer extends Random
{
	 //Declare one instance 
	 private static Randomizer _instance = new Randomizer();

	  public static Randomizer getInstance()
	  {
	    return _instance;
	  }

	  public Randomizer()
	  {
	  }

	  public Randomizer(long seed)
	  {
	    super(seed);
	  }

	  
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int[] nextInt(int n, int size)
	  {
	    if (size > n)
	    {
	      size = n;
	    }

	    Set set = new LinkedHashSet();

	    for (int i = 0; i < size; i++)
	    {
	      Integer value;
	      do value = new Integer(nextInt(n));

	      while (set.contains(value));
	      set.add(value);
	    }

	    int[] array = new int[set.size()];

	    Iterator itr = set.iterator();

	    for (int i = 0; i < array.length; i++)
	    {
	      array[i] = ((Integer)itr.next()).intValue();
	    }

	    return array;
	  }

	  /**
	   * 
	   * @param array
	   */
	  public void randomize(char[] array)
	  {
	    int length = array.length;

	    for (int i = 0; i < length - 1; i++)
	    {
	      int x = nextInt(length);
	      char y = array[i];

	      array[i] = array[(i + x)];
	      array[(i + x)] = y;

	      length--;
	    }
	  }

	  /**
	   * 
	   * @param array
	   */
	  public void randomize(int[] array)
	  {
	    int length = array.length;

	    for (int i = 0; i < length - 1; i++)
	    {
	      int x = nextInt(length);
	      int y = array[i];

	      array[i] = array[(i + x)];
	      array[(i + x)] = y;

	      length--;
	    }
	  }

	  /**
	   * 
	   * @param list
	   */
	  public void randomize(List<Object> list)
	  {
	    int size = list.size();

	    for (int i = 0; i <= size; i++)
	    {
	      Object obj = list.get(i);

	      int j = nextInt(size);

	      list.set(i, list.get(i + j));
	      list.set(i + j, obj);

	      size--;
	    }
	  }

	  /**
	   * 
	   * @param array
	   */
	  public void randomize(Object[] array) 
	  {
	    int length = array.length;

	    for (int i = 0; i < length - 1; i++) 
	    {
	      int x = nextInt(length);
	      Object y = array[i];

	      array[i] = array[(i + x)];
	      array[(i + x)] = y;

	      length--;
	    }
	  }

	  /**
	   * 
	   * @param s
	   * @return
	   */
	  public String randomize(String s)
	  {
	    if (s == null) {
	      return null;
	    }

	    char[] array = s.toCharArray();

	    randomize(array);

	    return new String(array);
	  }
}
