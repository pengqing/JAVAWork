package Day14_RegexTest;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Demo9_Biginterger {
	public static void main(String[] args){
		BigInteger b1=new BigInteger("100") ;
		BigInteger b2=new BigInteger("2");
		System.out.println(b1.add(b2));					//+
		System.out.println(b1.subtract(b2));			//-
		System.out.println(b1.divide(b2));				///
		System.out.println(b1.multiply(b2));			//*
		
		BigDecimal bl1=new BigDecimal("2.0");
		BigDecimal bl2=new BigDecimal("1.1");
		System.out.println(bl1.subtract(bl2));
		
	}
}
