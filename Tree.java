import java.util.*;
public class Tree {
    private treenode root;

    public class treenode {

        private int data;
        private treenode left;
        private treenode right;

        public treenode (int data){

            this.data=data;
        }

    }

    public void createBinaryTree(){
        treenode f=new treenode(1);
        treenode s=new treenode(2);
        treenode t=new treenode(3);
        treenode fo=new treenode(4);
        treenode five=new treenode(5);

        root=f;
        f.left=s;
        f.right=t;
        s.left= fo;
        s.right=five;

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

    public int height(treenode root){
        if(root==null){
            return -1;
        }

        int l = height(root.left);
        int r = height(root.right);


        if (l > r)
            return (l + 1);
        else
            return (r + 1);
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


    public static void main(String[] args){
       Tree t=new Tree();
       t.createBinaryTree();

       System.out.println("preorder traversal:");
       t.preOrder(t.root);

       System.out.println("\ninorder traversal:");
       t.inOrder(t.root);


       System.out.println("\npostorder traversal:");
       t.postOrder(t.root);

       int a= t.height(t.root);
       System.out.println("\nheight: "+a);

       System.out.println("\nlevelorder traversal:");
       t.levelOrder(t.root);

    }
}




