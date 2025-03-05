/*
 * TODO: Owen Girimonte 
 * TODO: Date 2/21/2025
 * TODO: Class Period 7
 * TODO: Creating a tree and testing methods made in the BST file 
 */

 import java.lang.Comparable;

 public class BSTTester {
   public static void main(String[] args) {
   // creation of tree and addition of elements
    BST tree = new BST();
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
// testing prints
   tree.printInOrder();
   System.out.println();
   tree.printPostOrder();
   System.out.println();
   tree.printPreOrder();
   System.out.println();

  // testing delete for all cases 
   System.out.println("Deleting E (has no children)");
   System.out.println("Result: "+tree.delete("E"));
   System.out.print("Resulting tree: ");
   tree.printInOrder();
   
   System.out.println();
   System.out.println();

   System.out.println("Deleting Q (has one child)");
   System.out.println("Result: "+tree.delete("Q"));
   System.out.print("Resulting tree: ");
   tree.printInOrder();

   System.out.println();
   System.out.println();

   System.out.println("Deleting C (has two children)");
   System.out.println("Result: "+tree.delete("C"));
   System.out.print("Resulting tree: ");
   tree.printInOrder();

   System.out.println();
   System.out.println();

   System.out.println("Deleting O (Root)");
   System.out.println("Result: "+tree.delete("O"));
   System.out.print("Resulting tree: ");
   tree.printInOrder();

   System.out.println();
   System.out.println();
   
   System.out.println("Deleting X (Not in tree)");
   System.out.println("Result: "+tree.delete("X"));
   System.out.print("Resulting tree: ");
   tree.printInOrder();
	
   System.out.println();
   System.out.println();
  
// testing find method 
   System.out.println("Finding A in the tree");
   System.out.println("Result: "+tree.find("A"));

   System.out.println();
   System.out.println();
  

   System.out.println("Finding X in the tree (Not in the tree)");
   System.out.println("Result: "+tree.find("X"));

   System.out.println();
   System.out.println();
   // testing  replace 
   System.out.println("Replacing U with Z in the tree");
   System.out.println("Result: "+ tree.replace("U","Z"));
   System.out.print("Resulting tree: ");
   tree.printInOrder();

   System.out.println();
   System.out.println();
   System.out.println();



   System.out.println("Replacing X(not in tree) with G in the tree");
   System.out.println("Result: "+ tree.replace("X","G"));
   System.out.print("Resulting tree: ");
   tree.printInOrder();

   System.out.println();
   System.out.println();
   System.out.println();

// testing size method 
   System.out.println("Testing Size Method");
   System.out.println("Size: "+tree.size());
 }
}