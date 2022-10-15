package palindrome_linked_list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

/** Решение через алгоритм Флойда */
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;

        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode result = slow;
        slow = slow.next;
        result.next = null;
        ListNode temp;

        while (slow != null) {
            temp = slow.next;
            slow.next = result;
            result = slow;
            slow = temp;
        }

        fast = head;
        slow = result;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }


// НЕЭФФЕКТИВНОЕ РЕШЕНИЕ
//    public boolean isPalindrome(ListNode head) {
//
//        if (head == null) {
//            return false;
//        }=
//
//        if (head.next == null) {
//            return true;
//        }
//
//        ListNode current = head;
//        int[] arr = new int[100000];
//
//        int i = 0;
//        while (current != null) {
//
//            arr[i] = current.val;
//            current = current.next;
//            i++;
//        }
//        int k = 0;
//        for (int j = i - 1; j >= 0; j--) {
//
//            if (arr[k] != arr[j]){
//                return false;
//            }
//            k++;
//
//        }
//        return true;
//   }
}
