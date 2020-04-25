//public class Solution {
//    public ListNode addTwoNumbers(ListNode A, ListNode B) {
//        ListNode head = null;
//        int sum = 0;
//        int carry = 0;
//        ListNode prev = null;
//        ListNode last = null;
//        while (A != null || B != null) {
//            sum=0;
//            if (A != null) {
//                sum = A.val;
//                A = A.next;
//            }
//            if (B != null) {
//                sum = sum + B.val;
//                B = B.next;
//            }
//            sum = sum + carry;
//            ListNode node = new ListNode(sum % 10);
//            carry = sum / 10 % 10;
//            if (head == null) {
//                head = node;
//                prev = node;
//            } else {
//                prev.next = node;
//                prev = node;
//            }
//            if (node.val != 0) {
//                last = node;
//            }
//        }
//        if (carry != 0) {
//            ListNode node = new ListNode(carry);
//            prev.next = node;
//            node.next = null;
//            last = node;
//        }
//        last.next = null;
//        return head;
//    }
//}
