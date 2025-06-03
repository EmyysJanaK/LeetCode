package MergeTwoSortedList;

public class Solution {
    public ListNode mergeTwoLists (ListNode list1, ListNode list2) {
        switch (list1 == null ? 0 : list2 == null ? 1 : 2) {
            case 0: return list2;
            case 1: return list1;
            default: break;
              
            case 2:
        ListNode head = new ListNode();
        ListNode current = head;
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
        switch (list1 == null ? 0 : list2 == null ? 1 : 2) {
            case 0:
                current.next = list2;
                break;
        
            default:
                break;
            case 1:
                current.next = list1;
                break;
        
            }

    
        return head.next;
            }
        }
    }
}

