package leetcode;

/**
 * Created by stan on 09/04/2021.
 */
public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList solution = new MyLinkedList();

        ListNode head = solution.createNode();

        ListNode reversedList =  solution.reverseList(head);

        solution.printList(reversedList);

    }

    public ListNode createNode(){

        ListNode tail = new ListNode(5);
        ListNode node = new ListNode(4, tail);
        node = new ListNode(3, node);
        node = new ListNode(2, node);
        node = new ListNode(1, node);

        return node;
    }

    public int getListLength(ListNode head) {
        int length = 0;
        while(head !=null) {
            length++;
            head = head.next;
        }

        return length;
    }

    public void printList(ListNode head){
        while(head!= null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public void deleteNode(ListNode node) {
        /*
        Input: head = [1,2,3,4], node = 3
        Output: [1,2,4]
        */

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null){
            return null;
        }

        /* length */
        ListNode iterator = head;
        int length = 1;
        while(iterator.next !=null) {
            iterator = iterator.next;
            length++;
        }

        if(n == length){
            return head.next;
        }

        length -=n;
        iterator = head;
        for(int i = 0; i < length - 1; i++){
            iterator = iterator.next;
        }

        if(iterator.next.next !=null) {
            iterator.next = iterator.next.next;
        } else {
            iterator.next = null;
        }

        return head;

    }

    public ListNode reverseList(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return head;

        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        if (cur != null) {
            cur.next = prev;
        }

        head.next = null;
        return cur;

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null && l2 ==null) return null;

        ListNode head = new ListNode();

        ListNode it = head;
        while(l1!=null && l2 !=null) {
            if(l1.val <= l2.val){
                it.val = l1.val;
                it.next = new ListNode();

                l1 = l1.next;
                it = it.next;
            } else {
                it.val = l2.val;
                it.next = new ListNode();

                l2 = l2.next;
                it = it.next;
            }

        }

        if(l1!=null){
            it.val = l1.val;
            it.next = l1.next;
        }

        if(l2!=null){
            it.val = l2.val;
            it.next = l2.next;
        }

        return head;

    }

    public boolean isPalindrome(ListNode head) {
        int length = getListLength(head);

        ListNode half = head;
        for(int i = 0; i < length / 2; i++) {
            half = half.next;
        }

        ListNode reversedHalf = reverseList(half);

        for(int i = 0; i < length / 2; i++) {
            if(head.val != reversedHalf.val ){
                return false;
            }

            head = head.next;
            reversedHalf = reversedHalf.next;
        }

        return true;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
