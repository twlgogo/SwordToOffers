import DataStructure.ListNode;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/8/13
 * Time: 下午9:44
 */
public class T52FIrstCommonNodeOfTwoLists {
  public static ListNode function(ListNode list1, ListNode list2) {
    if (list1 == null || list2 == null) return null;
    int length1 = getListLength(list1);
    int length2 = getListLength(list2);

    ListNode longHead = list2;
    ListNode shortHead = list1;
    int diff = length2 - length1;
    if (length1 > length2) {
      longHead = list1;
      shortHead = list2;
      diff = length1 - length2;
    }
    while (diff != 0) {
      longHead = longHead.nextNode;
      diff--;
    }
    while (longHead != null && shortHead != null && longHead != shortHead) {
      longHead = longHead.nextNode;
      shortHead = shortHead.nextNode;
    }
    return longHead;
  }

  public static ListNode function2(ListNode list1, ListNode list2) {
    if (list1 == null || list2 == null) return null;
    HashSet<ListNode> set = new HashSet<>();
    ListNode head1 = list1;
    ListNode head2 = list2;
    while (head1 != null && head2 != null) {
      if (!set.add(head1)) return head1;
      if (!set.add(head2)) return head2;
      head1 = head1.nextNode;
      head2 = head2.nextNode;
    }
    while (head1 != null) {
      if (!set.add(head1)) return head1;
      head1 = head1.nextNode;
    }
    while (head2 != null) {
      if (!set.add(head2)) return head2;
      head2 = head2.nextNode;
    }
    return null;
  }

  private static int getListLength(ListNode head) {
    int length = 0;
    ListNode node = head;
    while (node != null) {
      node = node.nextNode;
      length++;
    }
    return length;
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    ListNode node7 = new ListNode(7);
    node1.nextNode = node2;
    node2.nextNode = node3;
    node3.nextNode = node6;
    node6.nextNode = node7;
    node4.nextNode = node5;
    node5.nextNode = node6;

    ListNode commonNode = function2(node1, node4);
    System.out.println(commonNode.val);
  }
}
