import DataStructure.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/19
 * Time: 下午9:12
 */
public class EntryNodeOfLoop {
    public static ListNode function(ListNode head){
        if (head == null)return null;
        ListNode meetingNode = meetingNode(head);
        if(meetingNode == null)return null;
        int nodeNumber = 1 ;
        ListNode pNode = meetingNode;
        while (pNode.nextNode != meetingNode){
            pNode = pNode.nextNode;
            nodeNumber++;
        }
        ListNode p1 = head , p2 = head;
        for (int i = 0; i <nodeNumber ; i++) {
            p1 = p1.nextNode;
        }
        while(p1 != p2){
            p1 = p1.nextNode;
            p2 = p2.nextNode;
        }
        return p1;
    }

    private static ListNode meetingNode(ListNode head){
        ListNode slowNode = head.nextNode;
        if (slowNode == null)return null;
        ListNode fastNode = slowNode.nextNode;
        while (slowNode != null && fastNode != null){
            if (slowNode == fastNode)
                return fastNode;
            slowNode = slowNode.nextNode;
            fastNode = fastNode.nextNode;
            if (fastNode.nextNode != null)
                fastNode = fastNode.nextNode;
        }
        return null;
    }
}
