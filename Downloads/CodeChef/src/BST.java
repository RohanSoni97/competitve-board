import java.util.Stack;

class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 class BST {

    TreeNode root;
    Stack<Integer> s=new Stack<>();
    public BST()
    {
        root=null;
    }
     void insert(int key) {
         root = insertRec(root, key);
     }
     TreeNode insertRec(TreeNode root, int key) {

         /* If the tree is empty, return a new node */
         if (root == null) {
             root = new TreeNode(key);
             return root;
         }

         /* Otherwise, recur down the tree */
         if (key < root.val)
             root.left = insertRec(root.left, key);
         else if (key > root.val)
             root.right = insertRec(root.right, key);

         /* return the (unchanged) node pointer */
         return root;
     }
     void storeInStack(TreeNode root)
     {

     }

     public static void main(String[] args) {
        BST b=new BST();
         b.insert(50);
         b.insert(30);
         b.insert(20);
         b.insert(40);
         b.insert(70);
         b.insert(60);
         b.insert(80);
       //  b.
     }
}
