package MergeTwoSortedList;

public class Solution {
    public ListNode mergeTwoLists (ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode mergedHead = new ListNode();
        ListNode current = mergedHead;

        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return mergedHead.next;    
    }
    
}

