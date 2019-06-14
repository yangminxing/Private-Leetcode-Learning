package yangminxing.leetcode.AddTwoNumber;

import java.util.ArrayList;
import java.util.List;

class AddTwoNumber {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        b1.next = b2;

        AddTwoNumber s = new AddTwoNumber();
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

        if(curA == null && curB ==null){
            if (forwardNum == 1) {
                listResult.add(new ListNode(forwardNum));
            }
            return;
        }

        int aVal = curA==null?0:curA.val;
        int bVal = curB==null?0:curB.val;
        int sumVal = aVal + bVal + forwardNum;
        int forwardSing =0;
        if(sumVal>=10){
            forwardSing =1;
            sumVal = sumVal -10;
        }
        listResult.add(new ListNode(sumVal));
        calTwoNumber(listResult, curA==null?null:curA.next, curB==null?null:curB.next, forwardSing);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}