import DataStructure.ListNode;
import Util.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/18
 * Time: 下午10:27
 */
public class FindeKthNodeToTail {
    public static ListNode function(ListNode head ,int k){
        if (head == null || k == 0)return null;
        ListNode first = head ;
        for (int i = 0; i < k -1; i++) {
            if (first.nextNode != null){
                first = first.nextNode;
            }else return null;
        }
        ListNode result = head;
        while(first.nextNode != null){
            first = first.nextNode;
            result = result.nextNode;
        }
        return result;
    }

    public static void main(String[] args) {
        int [] values = {1,2,3,4,5,6};
        ListNode head = Tools.createList(values);
        ListNode res = function(null,0);
        System.out.println(res.val);
    }
}
