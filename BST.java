import java.util.*;
public class BST {
    treenode root;


    public class treenode {
        private int data;
        private treenode left;
        private treenode right;

        public treenode(){

            this.data=data;
        }
    }

    public treenode createnewnode(int k){
        treenode f=new treenode();
        f.data= k;
        f.left=null;
        f.right=null;
        return f;

    }


    public treenode insert (int v,treenode node){
        if(node ==null){
          createnewnode(v);
        }
        if(v<node.data)
            node.left= insert(v,node.left);

        else if(v>node.data)
            node.right= insert(v,node.right);

       return node;
    }

    public treenode remove(int v,treenode node){
        if(node ==null){
            return null;
        }

        if(v<node.data)
            node.left= remove(v,node.left);

        else if(v>node.data)
            node.right= remove(v,node.right);
        else {

        }

        return node;
    }

    public boolean search(int v,treenode node){
        if(node ==null){
            return false ;
        }
        boolean f= false;
        while(node !=null) {
            if (v < node.data)
                node = node.left;

            else if (v > node.data)
                node = node.right;
            else {
                 f= true;
                 break;
            }
        }

        return f;
    }

    public void preOrder(treenode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data);
        System.out.print(" ");

        preOrder(root.left);
        preOrder(root.right);
    }


    public void inOrder(treenode root){
        if(root==null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data);
        System.out.print(" ");
        preOrder(root.right);
    }

    public void postOrder(treenode root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data);

        System.out.print(" ");

    }

    public void levelOrder(treenode root){

        Queue<treenode> Q = new LinkedList<treenode>();
        Q.add(root);

        while(!Q.isEmpty()) {
            treenode n = Q.poll();
            System.out.print(n.data + " ");

            if(n.left != null) Q.add(n.left);
            if(n.right != null) Q.add(n.right);

        }
    }

    public static void main(String[] agrs){
        BST t=new BST();

        t.root=t.insert( 8, t.root);
        t.root=t.insert( 10,t.root);
        t.root=t.insert( 12,t.root);
        t.root=t.insert( 7, t.root);
        t.root=t.insert( 9, t.root);

       // System.out.println(t.root);

        System.out.println("\n remove:");
        t.remove(9,t.root);

        System.out.println("\n search:");
        t.search(12,t.root);

        System.out.println("\npreorder traversal:");
        t.preOrder(t.root);

        System.out.println("\ninorder traversal:");
        t.inOrder(t.root);

        System.out.println("\npostorder traversal:");
        t.postOrder(t.root);


    }
}
