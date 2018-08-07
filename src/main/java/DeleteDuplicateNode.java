import DataStructure.ListNode;
import Util.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/16
 * Time: 下午9:57
 */
public class DeleteDuplicateNode {
    public static void function(ListNode head){
        if (head == null)return;

        ListNode preNode = null;
        ListNode curNode = head;

        while(curNode != null){
            ListNode nextNode = curNode.nextNode;
            boolean needDelete = false;
            if (nextNode != null && curNode.val == nextNode.val){
                needDelete = true;
            }

            if (!needDelete){
                preNode = curNode;
                curNode = nextNode;
            }else {
                int value = curNode.val;
                ListNode toBeDelNode = curNode;
                while(toBeDelNode != null && toBeDelNode.val == value){
                    nextNode = toBeDelNode.nextNode;
                    toBeDelNode = nextNode;
                }
                if (preNode == null){
                    head = nextNode;
                }else {
                    curNode.nextNode = nextNode;
                }
                curNode = nextNode;
            }
        }
    }

    public static void main(String[] args) {
        int [] values ={1,2,2,3,3,5};
        ListNode head = Tools.createList(values);
        function(head);
        while (head.nextNode != null){
            System.out.println(head.val);
            head = head.nextNode;
        }
    }
}
