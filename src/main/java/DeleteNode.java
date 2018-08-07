import DataStructure.ListNode;
import Util.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/16
 * Time: 下午8:47
 */
public class DeleteNode {
    static class opListNode{
        ListNode node;
    }

    public static void function(opListNode head,ListNode tobeDeleted){
        if (head== null||tobeDeleted == null)return;
        if (tobeDeleted.nextNode != null){
            ListNode nextNode = tobeDeleted.nextNode;
            tobeDeleted.val = nextNode.val;
            tobeDeleted.nextNode = nextNode.nextNode;
        }else if (head.node == tobeDeleted){
            /**
             *存在bug，这里直接对传入值进行赋值，是不能对外
             *部的head产生影响的。因为此处是值传递，java中不能进行显式的地址传递
             * 此时采用静态内部类进行包装，则可以将值传递回去
             */
            head.node = null;
        }else {
            ListNode preNode = head.node;
            while(preNode.nextNode != tobeDeleted){
                preNode = preNode.nextNode;
            }
            preNode.nextNode = null;
        }
    }

    public static void main(String[] args) {
        int[] values = {1};
        ListNode head = Tools.createList(values);
        ListNode toBeDeleted = head;
        opListNode head1 = new opListNode();
        head1.node = head;
        function(head1,toBeDeleted);
        while (head1.node != null){
            System.out.println(head1.node.val);
            head1.node = head1.node.nextNode;
        }
    }
}
