package MergeTwoSortedList;

public class ListNode {
    int value;
    ListNode next;
    ListNode() {};
    ListNode(int value) { this.value = value; }
    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}


// class TestListNode {
//     public static void main(String[] args) {
//         ListNode node1 = new ListNode(1);
//         ListNode node2 = new ListNode(2, node1);
//         ListNode node3 = new ListNode(90, node2);

//         // Print the list
//         ListNode current = node3;
//         while (current != null) {
//             System.out.print(current.value + " ");
//             current = current.next;
//         }
//     }
// }
