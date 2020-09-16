package com.nikhil;

import java.util.PriorityQueue; 
import java.util.Scanner; 
import java.util.Comparator; 
import java.io.*;
import java.lang.*;
import java.util.*;
  
class HuffmanNode { 
  	
    int data; 
    char c; 
  
    HuffmanNode left; 
    HuffmanNode right; 
} 
  
class MyComparator implements Comparator<HuffmanNode> { 
    public int compare(HuffmanNode x, HuffmanNode y) 
    { 
  
       return x.data - y.data; 
    } 
} 

public class huffman {
	public static void printCode(HuffmanNode root, String s) 
    { 
        if (root.left == null&& root.right == null && Character.isLetter(root.c))
       { 
             System.out.println(root.c + ":" + s);  return; 
        } 
        printCode(root.left, s + "0"); 
        printCode(root.right, s + "1"); 
    } 

    public static void main(String[] args) throws IOException
    { 
	/* 
        int n = 6; 
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };
	*/
      char[] ch=new char[100];
      int c=0,n,index;
      char[] charArray={ 'a', 'b', 'c', 'd', 'e', 'f','g','h','i','j', 'k', 'l', 'm', 'n','o','p','q','r', 's', 't', 'u', 'v', 'w','x','y','z','A', 'B', 'C', 'D', 'E', 'F','G','H','I','J', 'K', 'L', 'M', 'N','O','P','Q','R', 'S', 'T', 'U', 'V', 'W','X','Y','Z' };
      int charfreq[]=new int[52];
      FileInputStream fin=new FileInputStream("C:\\Users\\Nikhil\\Desktop\\Javaprogram.txt");
    while((n=fin.read())!=-1)
   {
      ch[c]=(char)n;
      if(ch[c]==' ')
    	  continue;
      if(Character.isLowerCase(ch[c]))
      {
    	  index=(int)ch[c]-(int)'a';
    	  charfreq[index]++;
      }
      if(Character.isUpperCase(ch[c]))
      {
    	  index=(int)ch[c]-(int)'A'+26;
    	  charfreq[index]++;
      }
      c++;
      
    }
  
   		
        PriorityQueue<HuffmanNode> q 
            = new PriorityQueue<HuffmanNode>(ch.length, new MyComparator()); 
  
        for (int i = 0; i < 52; i++) { 
            HuffmanNode hn = new HuffmanNode(); 
            if(charfreq[i]!=0)
            {
            hn.c = charArray[i]; 
            hn.data = charfreq[i]; 
  
            hn.left = null; 
            hn.right = null;
            q.add(hn);
            }
        } 
        HuffmanNode root = null;
        while (q.size() > 1) { 
  
            HuffmanNode x = q.peek(); 
            q.poll();
            HuffmanNode y = q.peek();
            q.poll(); 
            HuffmanNode h = new HuffmanNode(); 
            h.data = x.data + y.data; 
            h.c = '-';
            h.left = x;
            h.right = y;
            root = h;
            q.add(h); 
        }
        printCode(root, ""); 
   			}

}
