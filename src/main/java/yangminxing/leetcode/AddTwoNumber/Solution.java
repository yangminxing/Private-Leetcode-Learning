package yangminxing.leetcode.AddTwoNumber;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
//        ListNode a1 = new ListNode(5);
//        ListNode a2 = new ListNode(4);
//        ListNode a3 = new ListNode(3);
//        a1.next = a2;
//        a2.next = a3;
//
//        ListNode b1 = new ListNode(5);
//        ListNode b2 = new ListNode(6);
//        ListNode b3 = new ListNode(4);
//        b1.next = b2;
//        b2.next = b3;
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        Solution s = new Solution();
        ListNode node = s.addTwoNumbers(a1, b1);
        System.out.println(node);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> list = new ArrayList<>();
        calTwoNumber(list, l1, l2, 0);
        for(int i=0;i<list.size()-1;i++){
            list.get(i).next = list.get(i+1);
        }
        return list.get(0);
    }

    public void calTwoNumber(List<ListNode> listResult, ListNode curA, ListNode curB, int forwardNum){
        if(forwardNum==1 && (curA == null || curB ==null)){
            listResult.add(new ListNode(forwardNum));
        }

        if(curA == null || curB ==null){
            return;
        }

        int aVal = curA.val;
        int bVal = curB.val;
        int sumVal = aVal + bVal + forwardNum;
        int forwardSing =0;
        if(sumVal>=10){
            forwardSing =1;
            sumVal = sumVal -10;
        }
        listResult.add(new ListNode(sumVal));
        calTwoNumber(listResult, curA.next, curB.next, forwardSing);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}