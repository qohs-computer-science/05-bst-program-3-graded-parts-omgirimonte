import java.lang.Comparable;
public class BST implements BSTInterface
{
    private TreeNode root;
    
    public BST(){
        root = null;
    }// end constructor 

    public void add(Comparable newVal){
        if (root==null){
            root = new TreeNode(newVal);
        }// end if 
        else{
            if (newVal.compareTo(root.getValue())<=0){
                if (root.getLeft()==null){
                    root.setLeft(new TreeNode(newVal));
                }// end if 
                else{
                    addHelper(newVal,root.getLeft());
                }//end else
            }//end if 
            else{
                if(root.getRight()==null){
                    root.setRight(new TreeNode(newVal));
                }//end if 
                else{
                    addHelper(newVal,root.getRight());
                }//end else
            }//end else
            
        }// end else
    }// end add

    private void addHelper(Comparable val, TreeNode subroot){
        if (val.compareTo(subroot.getValue())<=0){
            if (subroot.getLeft()==null){
                subroot.setLeft(new TreeNode(val));
            }// end if 
            else{
                addHelper(val,subroot.getLeft());
            }// end else 
        }// end else
            
        else{
            if (subroot.getRight()==null){
                subroot.setRight(new TreeNode(val));
            }// end if  
            else{
                addHelper(val,subroot.getRight());
            }// end else 
        }// end else 
        }// end addhelper
    



    public void printInOrder(){
        if (root!=null){
            printInHelper(root.getLeft());
            System.out.print(root.getValue());
            printInHelper(root.getRight());
        }// end if 

    }// end method 

    private void printInHelper(TreeNode subroot){
        if (subroot!=null){
            printInHelper(subroot.getLeft());
            System.out.print(subroot.getValue());
            printInHelper(subroot.getRight());
        }// end if 

    }// end method 





    public void printPostOrder(){
        if (root.getValue()!=null){
            printPostHelper(root.getLeft());
            printPostHelper(root.getRight());
            System.out.print(root.getValue());
        }// end if 
    }// end method 

    private void printPostHelper(TreeNode subroot){
        if (subroot!=null){
            printPostHelper(subroot.getLeft());
            printPostHelper(subroot.getRight());
            System.out.print(subroot.getValue());
        }// end if 
    }// end method 



    public void printPreOrder(){
        if (root.getValue()!=null){
            System.out.print(root.getValue());
            printPreHelper(root.getLeft());
            printPreHelper(root.getRight());
        }// end if 
    }// end method 



    private void printPreHelper(TreeNode subroot){
        if (subroot!=null){
            System.out.print(subroot.getValue());
            printPreHelper(subroot.getLeft());
            printPreHelper(subroot.getRight());
        }// end if 
    }// end method 


    public boolean isEmpty(){
        if (root==null){
            return true;
        }// end if
        return false;
    }// end method 
        
    public boolean delete(Comparable old){
        if (root==null){
            return false;
        }// end if 
        else{
            if (old.compareTo(root.getValue())==0){
                    deleteRoot();
                    return true;
            }// end if 
            else{
                if (old.compareTo(root.getValue())<=0){
                    if (root.getLeft()==null){
                        return false;
                    }//end if 
                    else{
                        if (old.compareTo(root.getLeft().getValue())==0){
                            doDelete(root,root.getLeft(),true);
                            return true;
                        }// end if 
                        else{
                            return deleteHelper(old,root.getLeft());
                        }// end else 
                    }//end else 
                }// end if
                else{
                    if (root.getRight()==null){
                        return false;
                    }// end if 
                    else{
                        if (old.compareTo(root.getRight().getValue())==0){
                            doDelete(root,root.getRight(),false);
                            return true;
                        }// end if 
                        else{
                            return deleteHelper(old, root.getRight());
                        }// end else 
                    }// end else 
                }// end else 
            }// end else 
        }// end else 
    }// end method 


    private boolean deleteHelper(Comparable val, TreeNode subroot){
        if (val.compareTo(subroot.getValue())<=0){
            if (subroot.getLeft()==null){
                return false;
            }// end if 
            else{
                if (val.compareTo(subroot.getLeft().getValue())==0){
                    doDelete(subroot,subroot.getLeft(),true);
                    return true;
                }// end if 
                else{
                    return deleteHelper(val,subroot.getLeft());
                }// // end else 
            }// end else 
        }// end else 
        else{
            if (subroot.getRight()==null){
                return false;
            }// end if 
            else{
                if (val.compareTo(subroot.getRight().getValue())==0){
                    doDelete(subroot,subroot.getRight(),false);
                    return true;
                }// end if 
                else{
                    return deleteHelper(val,subroot.getRight());
                }// end else 
            }// end else
        }// end else 
    }//end helper 



    private void doDelete (TreeNode parent, TreeNode child, boolean isLeft){
        if (child.getLeft()==null){
            if(child.getRight()==null){
                if (isLeft){
                    parent.setLeft(null);
                }// end if 
                else{
                    parent.setRight(null);
                }// end else 
            }// end if 
            else{
                if (isLeft){
                    parent.setLeft(parent.getRight());
                    parent.setRight(null);
                }// end if
                else{
                    parent.setRight(child.getRight());
                    child.setRight(null);
                }// end else 
            }//end if
        }
        else{
            if (child.getRight()==null){
                if (isLeft){
                    parent.setLeft(child.getLeft());
                    child.setLeft(null);
                }// end if 
                else{
                    parent.setRight(child.getLeft());
                    child.setLeft(null);
                }// end else 
            }// end else
            else{
                TreeNode val = child.getLeft();
                while(val.getRight()!=null){
                    val = val.getRight();
                }// end while 
                val.setRight(child.getRight());
                if(isLeft){
                    parent.setLeft(child.getLeft());
                }// end if 
                else{
                    parent.setRight(child.getLeft());
                }// end
                child.setLeft(null);
                child.setRight(null);
            }
        }
    }


    public boolean replace(Comparable old, Comparable val){
        if (find(old)==true){
            add(val);
            delete(old);
            return true;
        }// end if 
        add(val);
        return false; 
    }// end method 

    private void deleteRoot(){
        if (root.getLeft()==null){
            if (root.getRight()==null){
                root=null;
            }// end if 
            else{
                root=root.getRight();
            }// end else 
        }
        else{
            if (root.getRight()==null){
                root= root.getLeft();
            }// end if 
            else{
                TreeNode temp = root.getLeft();
                while (temp.getRight()!=null){
                    temp=temp.getRight();
                }// end while
                temp.setRight(root.getRight());
                root = root.getLeft();
            }// end else
        }// end else 
    }// end helper

    public boolean find(Comparable val){
        if (root==null )
            return false;
        else{
            if (root.getValue().compareTo(val)==0)
                return true;
        }// end else
        if (root.getValue().compareTo(val)>0)
            return findHelper(val,root.getLeft());
        else{
            return findHelper(val,root.getRight());
        }// end else
    }// end method
    


    private boolean findHelper(Comparable val,TreeNode subroot){
        if (subroot==null)
            return false;
        else
            if (subroot.getValue().compareTo(val)==0)
                return true;
            else{
                if (subroot ==val)
                return true;
            }// end else 
        if (subroot.getValue().compareTo(val)>1)
            return findHelper(val,subroot.getLeft());
        else
            return findHelper(val,subroot.getRight());
    }// end method



    public int size(){
        int count = 0;
        if (root!=null){
            count++;
            count+= sizeHelper(root.getLeft());
            count+= sizeHelper(root.getRight());
        }// end if
        return count;
    }// end method 

    private int sizeHelper(TreeNode subroot){
        int count = 0;
        if (subroot!=null){
            count++;
            count+= sizeHelper(subroot.getLeft());
            count+= sizeHelper(subroot.getRight());
        }// end if
        return count;
    }// end method 
    
}// end class