import DataStructure.ListNode;
import Util.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/19
 * Time: 下午10:08
 */
public class MegeSortedLinkList {
    public static ListNode function(ListNode head1, ListNode head2){
        if (head1 == null)
            return head2;
        else if (head2 == null)
            return head1;
        ListNode newHead = null;
        if (head1.val< head2.val){
            newHead = head1;
            newHead.nextNode = function(head1.nextNode,head2);
        }else {
            newHead = head2;
            newHead.nextNode = function(head1,head2.nextNode);
        }
        return newHead;
    }

    public static void main(String[] args) {
        int[] values = {1,2,3,5,7};
        ListNode head1 = Tools.createList(values);
        int[] values2 = {2,4,6};
        ListNode head2 = Tools.createList(values2);
        ListNode newHead = function(null,head2);
        Tools.printList(newHead);
    }
}
