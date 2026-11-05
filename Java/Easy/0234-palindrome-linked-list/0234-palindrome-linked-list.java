/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow =head , fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        ListNode prev = null;

        while(cur != null){
            ListNode next =cur.next;
            cur.next =prev;
            prev = cur;
            cur=next;
        }
        ListNode temp =head, newhead = prev;
        while(newhead != null){
            if(temp.val != newhead.val) return false;
            newhead = newhead.next;
            temp=temp.next;
        }

        return true;
    }
}