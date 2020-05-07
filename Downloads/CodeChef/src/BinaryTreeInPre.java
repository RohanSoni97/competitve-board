//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
///*class TreeNode {
//     int val;
//     TreeNode left;
//      TreeNode right;
//      TreeNode(int x) {
//       val = x;
//       left=null;
//       right=null;
//      }
//  }
//public class BinaryTreeInPre {
//    TreeNode root;
//    static int preIndex = 0;
//    public static void main(String[] args) {
//        BinaryTreeInPre binaryTreeInPre=new BinaryTreeInPre();
//        ArrayList<Integer> preOrder=new ArrayList<>();
//        preOrder.add(1);preOrder.add(2);preOrder.add(3);
//        ArrayList<Integer> inOrder=new ArrayList<>();
//        inOrder.add(2);inOrder.add(1);inOrder.add(3);
//
//        TreeNode root = binaryTreeInPre.buildTreeWrap(inOrder, preOrder, inOrder.size());
//            binaryTreeInPre.printInorder(root);
//    }
//
//    private TreeNode buildTreeWrap(ArrayList<Integer> inOrder, ArrayList<Integer> preOrder, int size) {
//        Map<Integer,Integer> map=new HashMap<>();
//        for (int i=0;i<size;i++)
//            map.put(inOrder.get(i),i);
//        return buildTree(inOrder,preOrder,0,size-1,map);
//    }
//
//    private TreeNode buildTree(ArrayList<Integer> inOrder, ArrayList<Integer> preOrder, int inStrt, int inEnd, Map<Integer, Integer> map) {
//        int e;
//        if(inStrt>inEnd)
//            return null;
//
//        TreeNode tNode=new TreeNode(e=preOrder.get(preIndex++));
//        if(inStrt==inEnd)
//            return tNode;
//
//        int inIndex=map.get(e);
//
//        tNode.left = buildTree(inOrder, preOrder, inStrt, inIndex - 1, map);
//        tNode.right = buildTree(inOrder, preOrder, inIndex + 1, inEnd, map);
//
//        return tNode;
//    }
//    void printInorder(TreeNode node)
//    {
//        if (node == null)
//            return;
//
//        /* first recur on left child */
//     /*   printInorder(node.left);
//
//        /* then print the data of node */
//       // System.out.print(node.val + " ");
//
//        /* now recur on right child */
//        printInorder(node.right);
//    }
//}
