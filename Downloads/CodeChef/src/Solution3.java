//
//
///**
// * Definition for singly-linked list with a random pointer.
// * class RandomListNode {
// *     int label;
// *     RandomListNode next, random;
// *     RandomListNode(int x) { this.label = x; }
// * };
// */
//class RandomListNode {
//      int label;
//      RandomListNode next, random;
//      RandomListNode(int x) { this.label = x; }
//  }
//public class Solution3 {
//    public RandomListNode copyRandomList(RandomListNode head) {
//        // Map to map the nodes of two linked list
//        HashMap<RandomListNode, RandomListNode> nodesMap = new HashMap<RandomListNode, RandomListNode>();
//        RandomListNode newHead = null;
//        RandomListNode previousNode = null;
//        while (head != null) {
//            RandomListNode node = null;
//
//            // checking node in map
//            node = getNode(head, nodesMap);
//
//            // initializing new head
//            if (newHead == null) {
//                newHead = node;
//            }
//            RandomListNode random = head.random;
//            RandomListNode random1 = null;
//
//            // checking random node in map
//            if (random != null) {
//                random1 = getNode(random, nodesMap);
//            }
//
//            // updating the new node values
//            node.random = random1;
//            if (previousNode != null) {
//                previousNode.next = node;
//            }
//            previousNode = node;
//
//            // incrementing the head
//            head = head.next;
//        }
//        return newHead;
//    }
//
//    private RandomListNode getNode(RandomListNode node, HashMap<RandomListNode, RandomListNode> nodesMap) {
//        RandomListNode newNode = null;
//        if (nodesMap.containsKey(node)) {
//            newNode = nodesMap.get(node);
//        } else {
//            newNode = new RandomListNode(node.label);
//            nodesMap.put(node, newNode);
//        }
//        return newNode;
//    }
//}
//
