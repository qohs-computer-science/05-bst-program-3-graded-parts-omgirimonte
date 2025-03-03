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
            if (newVal.compareTo(root.getValue())<=0){
                if (root.getLeft()==null){
                    root.setLeft(new TreeNode(newVal));
                }
                else{
                    addHelper(newVal,root.getLeft());
                }
            }
            else{
                if(root.getRight()==null){
                    root.setRight(new TreeNode(newVal));
                }
                else{
                    addHelper(newVal,root.getRight());
                }
            }
            
        }
    }// end add

    private void addHelper(Comparable val, TreeNode subroot){
        if (val.compareTo(subroot.getValue())<=0){
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
            System.out.print(root.getValue());
            printInHelper(root.getRight());
        }

    }

    private void printInHelper(TreeNode subroot){
        if (subroot!=null){
            printInHelper(subroot.getLeft());
            System.out.print(subroot.getValue());
            printInHelper(subroot.getRight());
        }

    }





    public void printPostOrder(){
        if (root.getValue()!=null){
            printPostHelper(root.getLeft());
            printPostHelper(root.getRight());
            System.out.print(root.getValue());
        }
    }

    private void printPostHelper(TreeNode subroot){
        if (subroot!=null){
            printPostHelper(subroot.getLeft());
            printPostHelper(subroot.getRight());
            System.out.print(subroot.getValue());
        }
    }



    public void printPreOrder(){
        if (root.getValue()!=null){
            System.out.print(root.getValue());
            printPreHelper(root.getLeft());
            printPreHelper(root.getRight());
        }
    }



    private void printPreHelper(TreeNode subroot){
        if (subroot!=null){
            System.out.print(subroot.getValue());
            printPreHelper(subroot.getLeft());
            printPreHelper(subroot.getRight());
        }
    }
        
    public boolean delete(Comparable old){
        if (root==null){
            return false;
        }
        else{
            if (old.compareTo(root.getValue())==0){
                    deleteRoot();
                    return true;
            }
            else{
                if (old.compareTo(root.getValue())<=0){
                    if (root.getLeft()==null){
                        return false;
                    }
                    else{
                        if (old.compareTo(root.getLeft().getValue())==0){
                            doDelete(root,root.getLeft(),true);
                            return true;
                        }
                        else{
                            return deleteHelper(old,root.getLeft());
                        }
                    }
                }
                else{
                    if (root.getRight()==null){
                        return false;
                    }
                    else{
                        if (old.compareTo(root.getRight().getValue())==0){
                            doDelete(root,root.getRight(),false);
                            return true;
                        }
                        else{
                            return deleteHelper(old, root.getRight());
                        }
                    }
                }
            }
        }
    }


    private boolean deleteHelper(Comparable val, TreeNode subroot){
        if (val.compareTo(subroot.getValue())<=0){
            if (subroot.getLeft()==null){
                return false;
            }
            else{
                if (val.compareTo(subroot.getLeft().getValue())==0){
                    doDelete(subroot,subroot.getLeft(),true);
                    return true;
                }
                else{
                    return deleteHelper(val,subroot.getLeft());
                }
            }
        }
        else{
            if (subroot.getRight()==null){
                return false;
            }
            else{
                if (val.compareTo(subroot.getRight().getValue())==0){
                    doDelete(subroot,subroot.getRight(),false);
                    return true;
                }
                else{
                    return deleteHelper(val,subroot.getRight());
                }
            }
        }
    }



    private void doDelete (TreeNode parent, TreeNode child, boolean isLeft){
        if (child.getLeft()==null){
            if(child.getRight()==null){
                if (isLeft){
                    parent.setLeft(null);
                }
                else{
                    parent.setRight(null);
                }
            }
            else{
                if (isLeft){
                    parent.setLeft(parent.getRight());
                    parent.setRight(null);
                }
                else{
                    parent.setRight(child.getRight());
                    child.setRight(null);
                }
            }
        }
        else{
            if (child.getRight()==null){
                if (isLeft){
                    parent.setLeft(child.getLeft());
                    child.setLeft(null);
                }
                else{
                    parent.setRight(child.getLeft());
                    child.setLeft(null);
                }
            }
            else{
                TreeNode val = child.getLeft();
                while(val.getRight()!=null){
                    val = val.getRight();
                }
                val.setRight(child.getRight());
                if(isLeft){
                    parent.setLeft(child.getLeft());
                }
                else{
                    parent.setRight(child.getLeft());
                }
                child.setLeft(null);
                child.setRight(null);
            }
        }
    }




    private void deleteRoot(){
        if (root.getLeft()==null){
            if (root.getRight()==null){
                root=null;
            }
            else{
                root=root.getRight();
            }
        }
        else{
            if (root.getRight()==null){
                root= root.getLeft();
            }
            else{
                TreeNode temp = root.getLeft();
                while (temp.getRight()!=null){
                    temp=temp.getRight();
                }
                temp.setRight(root.getRight());
                root = root.getLeft();
            }
        }
    }






    public boolean find(Comparable val){
        if (root==null )
            return false;
        else{
            if (root.getValue().compareTo(val)==0)
                return true;
        }
        if (root.getValue().compareTo(val)>0)
            return findHelper(val,root.getLeft());
        else{
            return findHelper(val,root.getRight());
        }
    }
    


    private boolean findHelper(Comparable val,TreeNode subroot){
        if (subroot==null)
            return false;
        else
            if (subroot.getValue().compareTo(val)==0)
                return true;
            else{
                if (subroot ==val)
                return true;
            }
        if (subroot.getValue().compareTo(val)>1)
            return findHelper(val,subroot.getLeft());
        else
            return findHelper(val,subroot.getRight());
    }
    

}
