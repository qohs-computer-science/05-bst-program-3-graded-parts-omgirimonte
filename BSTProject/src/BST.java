import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode root;
    
    public BST(){
        root = null;
    }

    public void add(Comapareable newVal){
        if (root==null){
            root = newVal;
            return false;
        }
        else{
            if (newVal.compareTo(root)<=0){
                if (root.leftChild()==null){
                    root.setLeft(newVal);
                }
                else{
                    addHelper(newVal,root.leftChild());
                }
            else{
                addHelper(newVal,root.rightChild());
            }
            }
        }
    }// end add

    private void addHelper(Comapareable val, TreeNode subroot){
        if (val.compareTo(subroot)<=0){
            if (subroot.leftChild()==null){
                subroot.setLeft(val);
            }
            else{
                addHelper(val,subroot.leftChild());
            }
        else{
            if (subroot.rightChild()==null){
                subroot.setRight(val);
            }
            else{
                addHelper(val,subroot.rightChild());
            }
        }
        }
    }// end addhelper
        
}
