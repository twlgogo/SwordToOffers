import DataStructure.ListNode;
import Util.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/19
 * Time: 下午9:38
 */
public class ReverseList {
    public static ListNode function(ListNode head){
        if (head == null)return null;
        ListNode newhead = null;
        ListNode curNode = head;
        ListNode preNode = null;
        while (curNode != null){
            ListNode nextNode = curNode.nextNode;
            curNode.nextNode = preNode;
            if (nextNode == null){
                newhead = curNode ;
            }
            preNode = curNode;
            curNode = nextNode;
        }
        return newhead;
    }

    public static void main(String[] args) {
        int[] values ={1};
        ListNode head = Tools.createList(values);
        ListNode newhead = function(head);
        while (newhead != null){
            System.out.println(newhead.val);
            newhead = newhead.nextNode;
        }
    }
}
