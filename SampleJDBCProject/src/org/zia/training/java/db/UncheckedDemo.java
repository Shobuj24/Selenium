package org.zia.training.java.db;

import java.io.*;
public class UncheckedDemo {

	public static void main(String args[]) throws ArrayIndexOutOfBoundsException, FileNotFoundException {
		int num[] = { 1, 2, 3, 4, 5 };
		System.out.println(num[5]);
	}

//	   public static void main(String args[]) {
//	      try {
//	         int a[] = new int[2];
//	         System.out.println("Access element three :" + a[3]);
//	      } catch (ArrayIndexOutOfBoundsException e) {
//	         System.out.println("Exception thrown  :" + e);
//	      }
//	      System.out.println("Out of the block");
//	   }
	
}
