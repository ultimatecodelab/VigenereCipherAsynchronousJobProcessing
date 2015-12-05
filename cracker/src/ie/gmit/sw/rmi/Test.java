package ie.gmit.sw.rmi;

import java.util.*;

public class Test {

   public static void main(String[] args) {

   // create a LinkedList
   LinkedList list = new LinkedList();

   // add some elements
   list.add("Hello");
   list.add(2);
   list.add("Chocolate");
   list.add("10");

   // print the list
   System.out.println("LinkedList:" + list);

   // retrieve and remove the last element of the list
   System.out.println("Last element of the list:" + list.poll());

   // print the list
   System.out.println("LinkedList:" + list);
   }
}