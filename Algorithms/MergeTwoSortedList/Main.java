package MergeTwoSortedList;

public class Main {
    public static void main(String[] args) {
        // Example usage
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        Solution solution = new Solution();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        // Print merged list
        while (mergedList != null) {
            System.out.print(mergedList.value + " ");
            mergedList = mergedList.next;
        }
    }
}
