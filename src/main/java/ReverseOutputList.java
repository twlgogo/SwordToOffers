import DataStructure.ListNode;
import Util.Tools;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: tanweiliang
 * Date: 2018/7/11
 * Time: 下午3:27
 */
public class ReverseOutputList {
    public static void function1(ListNode head){
        ListNode pNode = head;
        Stack<Integer> stack = new Stack<>();
        while (pNode != null){
            stack.push(pNode.val);
            pNode = pNode.nextNode;
        }
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    public static void function2(ListNode head){
        if (head == null)return;
        if (head.nextNode != null){
            function2(head.nextNode);
        }
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        int[] values = {};
        ListNode head = Tools.createList(values);
        function1(head);
    }
}

