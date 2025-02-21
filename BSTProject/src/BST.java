import java.lang.Comparable;
public class BST implements BSTInterface
{
    private TreeNode root;
    
    public BST(){
        root = null;
    }

    public void add(Comparable newVal){
        if (root==null){
            root = new TreeNode(newVal);
        }
        else{
            if (newVal.compareTo(root)<=0){
                if (root.getLeft()==null){
                    root.setLeft(new TreeNode(newVal));
                }
                else{
                    addHelper(newVal,root.getLeft());
                }
            }
            else{
                if(root.getRight()==null){
                    root.setRight(new TreeNode(val));
                }
                else{
                    addHelper(newVal,root.getRight());
                }
            }
            
        }
    }// end add

    private void addHelper(Comparable val, TreeNode subroot){
        if (val.compareTo(subroot)<=0){
            if (subroot.getLeft()==null){
                subroot.setLeft(new TreeNode(val));
            }
            else{
                addHelper(val,subroot.getLeft());
            }
        }
            
        else{
            if (subroot.getRight()==null){
                subroot.setRight(new TreeNode(val));
            }
            else{
                addHelper(val,subroot.getRight());
            }
        }
        }// end addhelper
    



    public void printInOrder(){
        if (root!=null){
            printInHelper(root.getLeft());
            System.out.println(root.getValue());
            printInHelper(root.getRight());
        }

    }

    private void printInHelper(TreeNode subroot){
        if (subroot!=null){
            printInHelper(subroot.getLeft());
            System.out.println(subroot.getValue());
            printInHelper(subroot.getRight());
        }

    }





    public void printPostOrder(){
        if (root!=null){
            printPostHelper(root.getLeft());
            printPostHelper(root.getRight());
            System.out.println(root.getValue());
        }
    }

    private void printPostHelper(TreeNode subroot){
        if (subroot!=null){
            printPostHelper(subroot.getLeft());
            printPostHelper(subroot.getRight());
            System.out.println(subroot.getValue());
        }
    }



    public void printPreOrder(){
        if (root!=null){
            System.out.println(root.getValue());
            printPreHelper(root.getLeft());
            printPreHelper(root.getRight());
        }
    }



    private void printPreHelper(TreeNode subroot){
        if (subroot!=null){
            System.out.println(subroot.getValue());
            printPreHelper(subroot.getLeft());
            printPreHelper(subroot.getRight());
        }
    }
        
}
