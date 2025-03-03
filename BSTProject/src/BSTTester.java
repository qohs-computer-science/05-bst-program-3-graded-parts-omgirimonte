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
   //tree.add("G");
   //tree.add("A");
   //tree.add("I");
   //tree.add("T");
   //tree.add("H");
   //tree.add("E");
   //tree.add("E");
   //tree.add("R");
   //tree.add("S");
   //tree.add("B");
   //tree.add("U");
   //tree.add("R");
   //tree.add("G");
   tree.add("O");
   tree.add("R");
   tree.add("C");
   tree.add("H");
   tree.add("A");
   tree.add("R");
   tree.add("D");
   tree.add("Q");
   tree.add("U");
   tree.add("I");
   tree.add("N");
   tree.add("C");
   tree.add("E");

   tree.printInOrder();
   System.out.println();
   tree.printPostOrder();
   System.out.println();
   tree.printPreOrder();

   System.out.println("Deleting E (has no children)");
   System.out.println("Result: "+tree.delete("E"));
   System.out.print("Resulting tree: ");
   tree.printInOrder();
   
   System.out.println();

   System.out.println("Deleting Q (has one child)");
   System.out.println("Result: "+tree.delete("Q"));
   System.out.print("Resulting tree: ");
   tree.printInOrder();

   System.out.println();

   System.out.println("Deleting C (has two children)");
   System.out.println("Result: "+tree.delete("C"));
   System.out.print("Resulting tree: ");
   tree.printInOrder();

   System.out.println();

   System.out.println("Deleting O (Root)");
   System.out.println("Result: "+tree.delete("O"));
   System.out.print("Resulting tree: ");
   tree.printInOrder();
	
 }
}