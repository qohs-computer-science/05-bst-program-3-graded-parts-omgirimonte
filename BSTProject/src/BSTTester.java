/*
 * TODO: Owen Girimonte 
 * TODO: Date 2/21/2025
 * TODO: Class Period 7
 * TODO: Program Description 
 */

 import java.lang.Comparable;

 public class BSTTester {
   public static void main(String[] args) {
   BST tree = new BST();
   tree.add("G");
   tree.add("A");
   tree.add("I");
   tree.add("T");
   tree.add("H");
   tree.add("E");
   tree.add("E");
   tree.add("R");
   tree.add("S");
   tree.add("B");
   tree.add("U");
   tree.add("R");
   tree.add("G");

   tree.printInOrder();
   tree.printPostOrder();
   tree.printPreOrder();
	
 }
}